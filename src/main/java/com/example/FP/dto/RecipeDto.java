package com.example.FP.dto;

import com.example.FP.entity.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter@Setter
@NoArgsConstructor
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

    public RecipeDto(Long id, String recipe_title, String recipe_writer, String recipe_url, String recipe_thumbnail, int recipe_views, RecipeCategory recipe_category, Member recipe_member) {
        this.id = id;
        this.recipe_title = recipe_title;
        this.recipe_writer = recipe_writer;
        this.recipe_url = recipe_url;
        this.recipe_thumbnail = recipe_thumbnail;
        this.recipe_views = recipe_views;
        this.recipe_category = recipe_category;
        this.recipe_member = recipe_member;
    }
}
