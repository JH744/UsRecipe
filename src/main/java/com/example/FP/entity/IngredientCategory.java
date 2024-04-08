package com.example.FP.entity;

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

    @Builder.Default
    @OneToMany(mappedBy = "ingredientIngredientCategory")
    private List<Ingredient> ingredientList = new ArrayList<>();

    public IngredientCategory() {
    }

    public IngredientCategory(String ingredientCategoryName, List<Ingredient> ingredientList) {
        this.ingredientCategoryName = ingredientCategoryName;
        this.ingredientList = ingredientList;
    }
}
