package com.example.FP.mapper;

import com.example.FP.dto.RecipeOrderDto;
import com.example.FP.entity.RecipeOrder;
import org.springframework.stereotype.Component;

@Component
public class RecipeOrderMapper {
    public static RecipeOrder toEntity(RecipeOrderDto recipeOrderDto){
        RecipeOrder recipeOrder = new RecipeOrder(recipeOrderDto.getRecipe_photo(), recipeOrderDto.getRecipe_detail(), recipeOrderDto.getRecipe_recipe_order());
        return recipeOrder;
    }
}
