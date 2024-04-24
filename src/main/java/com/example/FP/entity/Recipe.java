package com.example.FP.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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

    private String recipeTitle;
    private String recipeWriter;
    private String recipeUrl;
    private String recipeThumbnail;
    private int recipeViews;

    @Builder.Default
    @OneToMany(mappedBy = "wishlistRecipe", cascade = CascadeType.REMOVE)
    private List<WishList> wishlistList = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "recipeCategory_id")
    private RecipeCategory recipeCategory;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member recipeMember;

    @Builder.Default
    @OneToMany(mappedBy = "recipeIngredientRecipe")
    private List<RecipeIngredient> recipeIngredientList = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "cartRecipe", cascade = CascadeType.REMOVE)
    private List<Cart> recipeCartList = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "replyRecipe", cascade = CascadeType.REMOVE)
    private List<Reply> recipeReplyList = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "recipeRecipeOrder")
    private List<RecipeOrder> recipeRecipeOrderList = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "alarmRecipe", cascade = CascadeType.REMOVE)
    private List<Alarm> recipeAlarm = new ArrayList<>();


    public Recipe(String recipeTitle, String recipeWriter, String recipeUrl, String recipeThumbnail, int recipeViews, List<WishList> wishlistList, RecipeCategory recipeCategory, Member recipeMember, List<RecipeIngredient> recipeIngredientList, List<Cart> recipeCartList, List<Reply> recipeReplyList, List<RecipeOrder> recipeRecipeOrderList, List<Alarm> recipeAlarm) {
        this.recipeTitle = recipeTitle;
        this.recipeWriter = recipeWriter;
        this.recipeUrl = recipeUrl;
        this.recipeThumbnail = recipeThumbnail;
        this.recipeViews = recipeViews;
        this.wishlistList = wishlistList;
        this.recipeCategory = recipeCategory;
        this.recipeMember = recipeMember;
        this.recipeIngredientList = recipeIngredientList;
        this.recipeCartList = recipeCartList;
        this.recipeReplyList = recipeReplyList;
        this.recipeRecipeOrderList = recipeRecipeOrderList;
        this.recipeAlarm = recipeAlarm;
    }

    public Recipe(String recipeTitle) {
        this.recipeTitle = recipeTitle;
    }
}
