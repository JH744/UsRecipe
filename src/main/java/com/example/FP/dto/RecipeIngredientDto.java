package com.example.FP.dto;

import com.example.FP.entity.Ingredient;
import com.example.FP.entity.Recipe;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class RecipeIngredientDto {

    private Long id;

    private int recipe_ingredient_qty;
    private String recipe_ingredient_need;


    private Recipe recipe_ingredient_recipe;


    private Ingredient recipe_ingredient_ingredient;
}
