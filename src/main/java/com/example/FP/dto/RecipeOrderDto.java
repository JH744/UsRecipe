package com.example.FP.dto;

import com.example.FP.entity.Recipe;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RecipeOrderDto {
    private Long id;
    private String recipe_detail;
    private String recipe_photo;
    private Recipe recipe_recipe_order;

    public RecipeOrderDto(String recipe_detail, String recipe_photo, Recipe recipe_recipe_order) {
        this.recipe_detail = recipe_detail;
        this.recipe_photo = recipe_photo;
        this.recipe_recipe_order = recipe_recipe_order;
    }
}
