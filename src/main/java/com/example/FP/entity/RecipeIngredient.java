package com.example.FP.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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

    private int recipeIngredientQty;
    private String recipeIngredientNeed;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipeIngredientRecipe;

    @ManyToOne
    @JoinColumn(name = "ingredient_id")
    private Ingredient recipeIngredientIngredient;

    public RecipeIngredient(int recipeIngredientQty, String recipeIngredientNeed, Recipe recipeIngredientRecipe, Ingredient recipeIngredientIngredient) {
        this.recipeIngredientQty = recipeIngredientQty;
        this.recipeIngredientNeed = recipeIngredientNeed;
        this.recipeIngredientRecipe = recipeIngredientRecipe;
        this.recipeIngredientIngredient = recipeIngredientIngredient;
    }
}
