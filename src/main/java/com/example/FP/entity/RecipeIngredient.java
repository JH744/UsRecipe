package com.example.FP.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class RecipeIngredient {
    @Id@GeneratedValue
    @Column(name = "recipe_ingredient_id")
    private Long id;

    private int recipe_ingredient_qty;
    private String recipe_ingredient_need;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe_ingredient_recipe;

    @ManyToOne
    @JoinColumn(name = "ingredient_id")
    private Ingredient recipe_ingredient_ingredient;


}
