package com.example.FP.mapper;

import com.example.FP.dto.IngredientCategoryDto;
import com.example.FP.dto.MemberDto;
import com.example.FP.entity.IngredientCategory;
import com.example.FP.entity.Member;
import org.springframework.stereotype.Component;

@Component
public class IngerdientCaterotdyMapper {

    public static IngredientCategory toEntity(IngredientCategoryDto ingredientCategoryDto){
        IngredientCategory ingredientCategory = new IngredientCategory(ingredientCategoryDto.getIngredient_category_name(), ingredientCategoryDto.getIngredient_list());
        return ingredientCategory;
    }
}
