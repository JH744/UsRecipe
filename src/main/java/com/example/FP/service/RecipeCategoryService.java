package com.example.FP.service;

import com.example.FP.entity.RecipeCategory;
import com.example.FP.repository.RecipeCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class RecipeCategoryService {

    private final RecipeCategoryRepository rc;

    public List<RecipeCategory> findAllRecipeCategory(){
        return rc.findAll();
    }
}