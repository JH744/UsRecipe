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
    private int ingredient_price;
    private String ingredient_origin;
    private int ingredient_amount;
    private String ingredient_unit;
    private int ingredient_qty;

    @OneToMany(mappedBy = "recipe_ingredient")
    private List<Recipe> recipe_list = new ArrayList<>();

    @OneToMany(mappedBy = "recipe_ingredient_ingredient")
    private List<RecipeIngredient> recipe_ingredient_list = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "ingredient_category_id")
    private IngredientCategory ingredient_ingredient_category;

    @OneToMany(mappedBy = "orders_ingredient")
    private List<OrderDetails> ingredient_orderdetail_list = new ArrayList<>();

    @OneToMany(mappedBy = "cart_ingredient")
    private List<Cart> ingredient_cart_list = new ArrayList<>();
    @OneToMany(mappedBy = "reply_ingredient")
    private List<Reply> ingredient_reply_list = new ArrayList<>();

}
