package com.example.FP.service;

import com.example.FP.entity.Recipe;
import com.example.FP.entity.WishList;
import com.example.FP.repository.RecipeRepository;
import com.example.FP.repository.WishListRepository;
import com.example.FP.dto.RecipeDto;
import com.example.FP.dto.RecipeIngredientDto;
import com.example.FP.dto.RecipeOrderDto;
import com.example.FP.entity.*;
import com.example.FP.mapper.RecipeIngredientMapper;
import com.example.FP.mapper.RecipeOrderMapper;
import com.example.FP.mapper.RepiceMapper;
import com.example.FP.repository.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RecipeService {


    private final RecipeRepository rr;
    private final WishListRepository wr;
    private final RecipeIngredientRepository rir;
    private final RecipeOrderRepository ror;
    private final MemberService ms;
    private final RecipeCategoryRepository rcr;
    private final IngredientRepository ir;

    // 레시피 목록 불러오기
    public List<Recipe> findAll(){

        return rr.findAll();
    }

    //레시피 목록 카테고리+검색+ 페이지네이션//

    public Page<Recipe> listRecipes(String keyword,Long categoryId,Pageable pageable) {
        Page<Recipe> recipesList =
        rr.findByTitleContainingAndCategory(keyword, categoryId, pageable);

        return recipesList;
    }
    //레시피 전체 목록 + 페이지네이션 + 검색
    public Page<Recipe> listAll(Pageable pageable, String keyword) {
        return  rr.findByTitleContaining(keyword, pageable);
    }




    // 위시리스트에서 가장 많은 찜을 받은 레시피를 가져옴
    public List<Recipe> listTop4() {
        List<Object[]> top4Data = wr.findTopPopularRecipes(PageRequest.of(0, 4));
        List<Long> recipeIds = top4Data.stream()
                .map(entry -> (Long) entry[0]) // Object[]의 첫 번째 요소를 Long으로 캐스팅
                .collect(Collectors.toList());
        return rr.findByIdIn(recipeIds);
    }

    // 이 레시피 어때요?
    public Recipe HowAbout(){
        //총 레시피의 수를 구함
        long totalRecipe =  rr.count();
        Random r = new Random();
        //랜덤으로 레시피를 하나 가져옴. (1부터 총갯수만큼)
        Long randomId = r.nextLong(totalRecipe +1 );
        System.out.println("난수:"+randomId);
              Optional<Recipe> optional = rr.findById(randomId);
        Recipe recipe =optional.get();
            return recipe;
    }









    // 메인페이지 5개 보여줄 레시피
    public List<Recipe> top5(){
        return rr.findTop5ByOrderByRecipeViewsDesc();
    }
    
    // 랜덤으로 레시피 5개 리턴
    public List<Recipe> randomList(){
        List<Recipe> list = rr.findAll();
        Collections.shuffle(list);
        List<Recipe> randomRecipes = list.subList(0, Math.min(5, list.size()));
        return  randomRecipes;
    }

    public void insertRecipe(Map<String, Object> recipeDataList,String userid){
        RecipeDto recipeDto = null;
        Long recipeId = rr.nextRecipeId();
        Member member = ms.findById(userid);
        try {
            // Jackson ObjectMapper 객체 생성
            ObjectMapper mapper = new ObjectMapper();

            // JSON 문자열을 Map 객체로 변환
            Map<String, Object> jsonMap = mapper.readValue(recipeDataList.get("recipeDataList").toString(), Map.class);

            // 필요한 데이터 추출
            List<Map<String, Object>> ingredientDataList = (List<Map<String, Object>>) jsonMap.get("ingredientDataList");
            List<Map<String, Object>> stepDataList = (List<Map<String, Object>>) jsonMap.get("stepDataList");
            String recipeThumbnail = jsonMap.get("recipeThumbnail").toString();
            String recipeTitle = jsonMap.get("recipeTitle").toString();
            Long recipeCategoryId = Long.parseLong(jsonMap.get("recipeCategory").toString());
            RecipeCategory recipeCategory = rcr.findById(recipeCategoryId).get();

            recipeDto = new RecipeDto(recipeId,recipeTitle,member.getUserid(),null,recipeThumbnail,0,recipeCategory,member);
            Recipe recipe = RepiceMapper.toEntity(recipeDto);
            rr.save(recipe);

            for(Map<String, Object> i : ingredientDataList){
                Long recipeIngredientId = Long.parseLong(i.get("recipeIngredientId").toString());
                Ingredient ingredient = ir.findById(recipeIngredientId).get();
                RecipeIngredientDto rid = new RecipeIngredientDto(
                        Integer.parseInt(i.get("recipeIngredientQty").toString()),
                        i.get("recipeIngredientNeed").toString(),
                        recipe,
                        ingredient,
                        i.get("recipeIngredientUnit").toString()
                        );
                RecipeIngredient recipeIngredient = RecipeIngredientMapper.toEntity(rid);
                rir.save(recipeIngredient);
            }

            for(Map<String, Object> s : stepDataList){
                RecipeOrderDto recipeOrderDto = new RecipeOrderDto(
                        s.get("recipeDetail").toString(),
                        s.get("recipePhoto").toString(),
                        recipe);
                RecipeOrder recipeOrder = RecipeOrderMapper.toEntity(recipeOrderDto);
                ror.save(recipeOrder);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//
//    public Map<String,Object> detailRecipe(Long id){
//        Map<String,Object> recipeDetail = new HashMap<String,Object>();
//        List<RecipeIngredient> recipeIngredient = rir.findAllByRecipeIngredientRecipe();
//
//        recipeDetail.put("recipe",rr.findById(id).get());
//        recipeDetail.put("recipeIngredient",recipeIngredient);
//        recipeDetail.put("recipe",rr.findById(id).get());
//        recipeDetail.put("recipe",rr.findById(id).get());
//
//        return recipeDetail;
//    }

    @Transactional
    public Recipe detailRecipe(Long id){
        rr.UpdateRecipeViews(id);
        return rr.findById(id).get();
    }


    public void deleteRecipe(Long id) {
        rr.deleteById(id);
    }
}