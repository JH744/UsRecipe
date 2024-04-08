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
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Ingredient {
    @Id@GeneratedValue
    @Column(name = "ingredient_id")
    private Long id;

    private String ingredient_name;
    private int ingredientPrice;
    private String ingredient_origin;
    private int ingredient_amount;
    private String ingredient_unit;
    private int ingredient_qty;

    @Builder.Default
    @OneToMany(mappedBy = "recipe_ingredient_ingredient")
    private List<RecipeIngredient> recipe_ingredient_list = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "ingredient_category_id")
    private IngredientCategory ingredient_ingredient_category;

    @Builder.Default
    @OneToMany(mappedBy = "orders_ingredient")
    private List<OrderDetails> ingredient_orderdetail_list = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "cart_ingredient")
    private List<Cart> ingredient_cart_list = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "reply_ingredient")
    private List<Reply> ingredient_reply_list = new ArrayList<>();

    public Ingredient(String ingredient_name, int ingredientPrice, String ingredient_origin, int ingredient_amount, String ingredient_unit, int ingredient_qty, List<RecipeIngredient> recipe_ingredient_list, IngredientCategory ingredient_ingredient_category, List<OrderDetails> ingredient_orderdetail_list, List<Cart> ingredient_cart_list, List<Reply> ingredient_reply_list) {
        this.ingredient_name = ingredient_name;
        this.ingredientPrice = ingredientPrice;
        this.ingredient_origin = ingredient_origin;
        this.ingredient_amount = ingredient_amount;
        this.ingredient_unit = ingredient_unit;
        this.ingredient_qty = ingredient_qty;
        this.recipe_ingredient_list = recipe_ingredient_list;
        this.ingredient_ingredient_category = ingredient_ingredient_category;
        this.ingredient_orderdetail_list = ingredient_orderdetail_list;
        this.ingredient_cart_list = ingredient_cart_list;
        this.ingredient_reply_list = ingredient_reply_list;
    }
}
