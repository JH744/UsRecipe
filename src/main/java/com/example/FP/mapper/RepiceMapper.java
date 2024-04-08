package com.example.FP.mapper;

import com.example.FP.dto.RecipeDto;
import com.example.FP.entity.Recipe;
import org.springframework.stereotype.Component;

@Component
public class RepiceMapper {
    public static Recipe toEntity(RecipeDto recipeDto){
        Recipe recipe = new Recipe(recipeDto.getRecipe_title(), recipeDto.getRecipe_writer(), recipeDto.getRecipe_url(), recipeDto.getRecipe_thumbnail(), recipeDto.getRecipe_views(), recipeDto.getWishlist_list(),recipeDto.getRecipe_category(),recipeDto.getRecipe_member(),recipeDto.getRecipe_ingredient_list(),recipeDto.getRecipe_cart_list(),recipeDto.getRecipe_reply_list(), recipeDto.getRecipe_recipe_order_list() ,recipeDto.getRecipe_alarm());
        return recipe;


    }
}
