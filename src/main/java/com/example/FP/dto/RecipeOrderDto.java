package com.example.FP.dto;

import com.example.FP.entity.Recipe;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RecipeOrderDto {
    private Long id;
    private String recipe_detail;
    private String recipe_photo;
    private Recipe recipe_recipe_order;


}
