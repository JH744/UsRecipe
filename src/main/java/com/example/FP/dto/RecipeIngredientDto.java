package com.example.FP.dto;

import com.example.FP.entity.Ingredient;
import com.example.FP.entity.Recipe;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter
@NoArgsConstructor
public class RecipeIngredientDto {

    private Long id;

    private int recipe_ingredient_qty;
    private String recipe_ingredient_need;
    private String recipe_ingredient_unit;


    private Recipe recipe_ingredient_recipe;


    private Ingredient recipe_ingredient_ingredient;

    public RecipeIngredientDto(int recipe_ingredient_qty, String recipe_ingredient_need, Recipe recipe_ingredient_recipe, Ingredient recipe_ingredient_ingredient,String recipe_ingredient_unit) {
        this.recipe_ingredient_qty = recipe_ingredient_qty;
        this.recipe_ingredient_need = recipe_ingredient_need;
        this.recipe_ingredient_recipe = recipe_ingredient_recipe;
        this.recipe_ingredient_ingredient = recipe_ingredient_ingredient;
        this.recipe_ingredient_unit = recipe_ingredient_unit;
    }
}
