package com.example.FP.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class RecipeOrder {

    @Id@GeneratedValue
    @Column(name = "recipe_order_id")
    private Long id;
    private String recipe_detail;
    private String recipe_photo;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe_recipe_order;

    public RecipeOrder(String recipe_detail, String recipe_photo, Recipe recipe_recipe_order){
        this.recipe_detail = recipe_detail;
        this.recipe_photo = recipe_photo;
        this.recipe_recipe_order = recipe_recipe_order;
    }
}
