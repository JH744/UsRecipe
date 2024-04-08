package com.example.FP.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cart {
    @Id@GeneratedValue
    @Column(name = "cart_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member cartMember;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe cartRecipe;
    @ManyToOne
    @JoinColumn(name = "ingredient_id")
    private Ingredient cartIngredient;

    public Cart(Member cart_member, Recipe cart_recipe, Ingredient cart_ingredient) {
        this.cartMember = cart_member;
        this.cartRecipe = cart_recipe;
        this.cartIngredient = cart_ingredient;
    }
}
