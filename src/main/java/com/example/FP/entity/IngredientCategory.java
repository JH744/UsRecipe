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

    private String ingredient_category_name;

    @Builder.Default
    @OneToMany(mappedBy = "ingredient_ingredient_category")
    private List<Ingredient> ingredient_list = new ArrayList<>();

    public IngredientCategory() {
    }

    public IngredientCategory(String ingredient_category_name, List<Ingredient> ingredient_list) {
        this.ingredient_category_name = ingredient_category_name;
        this.ingredient_list = ingredient_list;
    }
}
