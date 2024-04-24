package com.example.FP.service;

import com.example.FP.repository.RecipeIngredientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RecipeIngredientService {
    private final RecipeIngredientRepository rir;

    @Transactional
    public void updateIngredientId(Long ingredient_id){
        rir.updateIngredientId(ingredient_id);
    }
}
