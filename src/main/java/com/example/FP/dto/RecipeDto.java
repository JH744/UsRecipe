package com.example.FP.dto;

import com.example.FP.entity.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter@Setter
public class RecipeDto {

    private Long id;

    private String recipe_title;
    private String recipe_writer;
    private String recipe_url;
    private String recipe_thumbnail;
    private int recipe_views;


    private List<WishList> wishlist_list = new ArrayList<>();


    private RecipeCategory recipe_category;

    private Member recipe_member;


    private List<RecipeIngredient> recipe_ingredient_list = new ArrayList<>();


    private List<Cart> recipe_cart_list = new ArrayList<>();


    private List<Reply> recipe_reply_list = new ArrayList<>();

    private List<RecipeOrder> recipe_recipe_order_list = new ArrayList<>();

    private List<Alarm> recipe_alarm = new ArrayList<>();
}
