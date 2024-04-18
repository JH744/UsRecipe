package com.example.FP.repository;

import com.example.FP.entity.Recipe;
import com.example.FP.entity.RecipeIngredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RecipeIngredientRepository extends JpaRepository<RecipeIngredient,Long> {

//    List<RecipeIngredient> findAllByRecipeIngredientRecipe();

    @Modifying
    @Query(value = "delete from recipe_ingredient where recipe_id=?1",nativeQuery = true)
    void deleteAllByPreviousRecipeIgredient(Long recipe_id);
}
