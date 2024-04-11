package com.example.FP.service;

import com.example.FP.dto.RecipeDto;
import com.example.FP.dto.RecipeIngredientDto;
import com.example.FP.dto.RecipeOrderDto;
import com.example.FP.entity.*;
import com.example.FP.mapper.RecipeIngredientMapper;
import com.example.FP.mapper.RecipeOrderMapper;
import com.example.FP.mapper.RepiceMapper;
import com.example.FP.repository.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RecipeService {


    private final RecipeRepository rr;
    private final RecipeIngredientRepository rir;
    private final RecipeOrderRepository ror;
    private final MemberService ms;
    private final RecipeCategoryRepository rcr;
    private final IngredientRepository ir;

// 레시피 목록 불러오기
//    public List<Recipe> list(){
//
//        return rr.findAll();
//    }

    //레시피 목록 페이지네이션//
    public Page<Recipe> list(){
        Page<Recipe> recipesList = rr.findPageBy(PageRequest.of(0,8));

        return recipesList;
    }


    public Optional<Recipe> HowAbout(Long id){

        return rr.findById(id);
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
}