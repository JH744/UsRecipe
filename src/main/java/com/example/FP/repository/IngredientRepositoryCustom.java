package com.example.FP.repository;

import com.example.FP.entity.Ingredient;
import com.example.FP.entity.IngredientCategory;

import java.util.List;

public interface IngredientRepositoryCustom {
    List<IngredientCategory> findAllIngredientCategory();
}
