package com.example.FP.service;

import com.example.FP.entity.Ingredient;
import com.example.FP.entity.Recipe;
import com.example.FP.repository.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

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

    //레시피 목록 페이지네이션//
    public Page<Recipe> list(){
        Page<Recipe> recipesList = rr.findPageBy(PageRequest.of(0,8));

        return recipesList;
    }


    public Optional<Recipe> HowAbout(Long id){

        return rr.findById(id);
    }



}