package com.example.FP.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class RecipeOrder {

    @Id@GeneratedValue
    @Column(name = "recipe_order_id")
    private Long id;
    private String recipeDetail;
    private String recipePhoto;

    @ManyToOne
    @JoinColumn(name = "recipeId")
    private Recipe recipeRecipeOrder;

    public RecipeOrder(String recipeDetail, String recipePhoto, Recipe recipeRecipeOrder){
        this.recipeDetail = recipeDetail;
        this.recipePhoto = recipePhoto;
        this.recipeRecipeOrder = recipeRecipeOrder;
    }
}
