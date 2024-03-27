package com.example.FP.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
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

    @OneToMany(mappedBy = "recipe_ingredient_recipe")
    private List<RecipeIngredient> recipe_ingredient_list = new ArrayList<>();

    @OneToMany(mappedBy = "cart_recipe")
    private List<Cart> recipe_cart_list = new ArrayList<>();

    @OneToMany(mappedBy = "reply_recipe")
    private List<Reply> recipe_reply_list = new ArrayList<>();


}
