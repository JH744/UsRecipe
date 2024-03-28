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
public class Recipe {
    @Id@GeneratedValue
    @Column(name = "recipe_id")
    private Long id;

    private String recipe_title;
    private String recipe_writer;
    private String recipe_url;
    private String recipe_thumbnail;
    private String recipe_photo;
    private String recipe_detail;
    private int recipe_views;

    @Builder.Default
    @OneToMany(mappedBy = "wishlist_recipe")
    private List<WishList> wishlist_list = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "recipe_category_id")
    private RecipeCategory recipe_category;

    @ManyToOne
    @JoinColumn(name = "ingredient_id")
    private Ingredient recipe_ingredient;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member recipe_member;

    @Builder.Default
    @OneToMany(mappedBy = "recipe_ingredient_recipe")
    private List<RecipeIngredient> recipe_ingredient_list = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "cart_recipe")
    private List<Cart> recipe_cart_list = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "reply_recipe")
    private List<Reply> recipe_reply_list = new ArrayList<>();


    public Recipe(String recipe_title, String recipe_writer, String recipe_url, String recipe_thumbnail, String recipe_photo, String recipe_detail, int recipe_views, List<WishList> wishlist_list, RecipeCategory recipe_category, Ingredient recipe_ingredient, Member recipe_member, List<RecipeIngredient> recipe_ingredient_list, List<Cart> recipe_cart_list, List<Reply> recipe_reply_list) {
        this.recipe_title = recipe_title;
        this.recipe_writer = recipe_writer;
        this.recipe_url = recipe_url;
        this.recipe_thumbnail = recipe_thumbnail;
        this.recipe_photo = recipe_photo;
        this.recipe_detail = recipe_detail;
        this.recipe_views = recipe_views;
        this.wishlist_list = wishlist_list;
        this.recipe_category = recipe_category;
        this.recipe_ingredient = recipe_ingredient;
        this.recipe_member = recipe_member;
        this.recipe_ingredient_list = recipe_ingredient_list;
        this.recipe_cart_list = recipe_cart_list;
        this.recipe_reply_list = recipe_reply_list;
    }

    public Recipe(String recipe_title) {
        this.recipe_title = recipe_title;
    }
}
