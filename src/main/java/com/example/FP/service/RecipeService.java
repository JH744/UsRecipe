package com.example.FP.service;

import com.example.FP.entity.Recipe;
import com.example.FP.repository.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RecipeService {


    private final RecipeRepository rr;

// 레시피 목록 불러오기
//    public List<Recipe> list(){
//
//        return rr.findAll();
//    }

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


}