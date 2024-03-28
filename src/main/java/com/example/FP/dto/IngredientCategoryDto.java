package com.example.FP.dto;

import com.example.FP.entity.Ingredient;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter@Setter
public class IngredientCategoryDto {

    private Long id;

    private String ingredient_category_name;

    private List<Ingredient> ingredient_list;
}
