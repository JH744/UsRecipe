package com.example.FP.mapper;

import com.example.FP.dto.NoticeDto;
import com.example.FP.dto.RecipeCategoryDto;
import com.example.FP.entity.Notice;
import com.example.FP.entity.RecipeCategory;
import org.springframework.stereotype.Component;

@Component
public class RecipeCategoryMapper {
    public static RecipeCategory toEntity(RecipeCategoryDto recipeCategoryDto){
        RecipeCategory recipeCategory = new RecipeCategory(recipeCategoryDto.getRecipe_category_name(), recipeCategoryDto.getRecipe_list());
        return recipeCategory;


    }
}
