package com.example.FP.dto;

import com.example.FP.entity.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter@Setter
public class IngredientDto {

    private Long id;

    private String ingredient_name;
    private int ingredient_price;
    private String ingredient_origin;
    private int ingredient_amount;
    private String ingredient_unit;
    private int ingredient_qty;


    private List<Recipe> recipe_list = new ArrayList<>();


    private List<RecipeIngredient> recipe_ingredient_list = new ArrayList<>();


    private IngredientCategory ingredient_ingredient_category;


    private List<OrderDetails> ingredient_orderdetail_list = new ArrayList<>();


    private List<Cart> ingredient_cart_list = new ArrayList<>();

    private List<Reply> ingredient_reply_list = new ArrayList<>();
}
