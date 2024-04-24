package com.example.FP.repository;

import com.example.FP.entity.Recipe;
import com.example.FP.entity.RecipeIngredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RecipeIngredientRepository extends JpaRepository<RecipeIngredient,Long> {

//    List<RecipeIngredient> findAllByRecipeIngredientRecipe();

    @Query(value = "select max(recipe_ingredient_id) from recipe_ingredient where recipe_id=?1",nativeQuery = true)
    Long PreviousRecipeIngredientMaxId(Long recipe_id);

    @Modifying
    @Query(value = "delete from recipe_ingredient where recipe_id=?1 and recipe_ingredient_id<=?2",nativeQuery = true)
    void deleteAllByPreviousRecipeIngredient(Long recipe_id,Long recipe_ingredient_id);

    @Modifying
    @Query(value = "update recipe_ingredient set ingredient_id=null where ingredient_id=?1",nativeQuery = true)
    void updateIngredientId(Long ingredient_id);
}
