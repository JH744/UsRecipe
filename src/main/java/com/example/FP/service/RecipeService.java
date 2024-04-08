package com.example.FP.service;

import com.example.FP.entity.Recipe;
import com.example.FP.entity.RecipeIngredient;
import com.example.FP.repository.RecipeIngredientRepository;
import com.example.FP.repository.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RecipeService {
    private final RecipeRepository rr;
    private final RecipeIngredientRepository rir;
    public void save(Recipe recipe){

    }

}
