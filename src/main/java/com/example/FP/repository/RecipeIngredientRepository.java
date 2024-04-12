package com.example.FP.repository;

import com.example.FP.entity.RecipeIngredient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecipeIngredientRepository extends JpaRepository<RecipeIngredient,Long> {

//    List<RecipeIngredient> findAllByRecipeIngredientRecipe();
}
