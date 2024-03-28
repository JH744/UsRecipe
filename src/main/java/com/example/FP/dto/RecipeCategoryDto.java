package com.example.FP.dto;

import com.example.FP.entity.Recipe;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter@Setter
public class RecipeCategoryDto {

    private Long id;

    private String recipe_category_name;


    private List<Recipe> recipe_list = new ArrayList<>();
}
