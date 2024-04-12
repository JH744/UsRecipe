package com.example.FP.mapper;
import com.example.FP.dto.IngredientDto;
import com.example.FP.entity.Ingredient;
import org.springframework.stereotype.Component;

@Component
public class IngredientMapper {
    public static Ingredient toEntity(IngredientDto ingredientDto){
        Ingredient ingredient = new Ingredient(ingredientDto.getIngredient_name(), ingredientDto.getIngredient_price(), ingredientDto.getIngredient_origin(), ingredientDto.getIngredient_amount(), ingredientDto.getIngredient_unit(), ingredientDto.getIngredient_qty(),ingredientDto.getIngredient_ingredient_category());
        return ingredient;

    }
}
