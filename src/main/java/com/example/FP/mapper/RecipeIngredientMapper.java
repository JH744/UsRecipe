package com.example.FP.mapper;

import com.example.FP.dto.NoticeDto;
import com.example.FP.dto.RecipeIngredientDto;
import com.example.FP.entity.Notice;
import com.example.FP.entity.RecipeIngredient;
import org.springframework.stereotype.Component;

@Component
public class RecipeIngredientMapper {
    public static RecipeIngredient toEntity(RecipeIngredientDto recipeIngredientDto){
        RecipeIngredient recipeIngredient = new RecipeIngredient(recipeIngredientDto.getRecipe_ingredient_qty(), recipeIngredientDto.getRecipe_ingredient_need(),recipeIngredientDto.getRecipe_ingredient_recipe(),recipeIngredientDto.getRecipe_ingredient_ingredient(),recipeIngredientDto.getRecipe_ingredient_unit());
        return recipeIngredient;


    }
}
