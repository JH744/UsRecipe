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
    private Member cart_member;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe cart_recipe;
    @ManyToOne
    @JoinColumn(name = "ingredient_id")
    private Ingredient cart_ingredient;

    public Cart(Member cart_member, Recipe cart_recipe, Ingredient cart_ingredient) {
        this.cart_member = cart_member;
        this.cart_recipe = cart_recipe;
        this.cart_ingredient = cart_ingredient;
    }
}
