package com.example.FP.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@Getter

public class IngredientCategory {
    @Id@GeneratedValue
    @Column(name = "ingredient_category_id")
    private Long id;

    private String ingredientCategoryName;


    public IngredientCategory() {
    }

    public IngredientCategory(String ingredientCategoryName) {
        this.ingredientCategoryName = ingredientCategoryName;
    }
}
