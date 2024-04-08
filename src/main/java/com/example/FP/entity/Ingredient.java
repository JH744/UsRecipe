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

    private String ingredientName;
    private int ingredientPrice;
    private String ingredientOrigin;
    private int ingredientAmount;
    private String ingredientUnit;
    private int ingredientQty;

    @Builder.Default
    @OneToMany(mappedBy = "recipeIngredientIngredient")
    private List<RecipeIngredient> recipeIngredientList = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "ingredient_category_id")
    private IngredientCategory ingredientIngredientCategory;

    @Builder.Default
    @OneToMany(mappedBy = "ordersIngredient")
    private List<OrderDetails> ingredientOrderdetailList = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "cartIngredient")
    private List<Cart> ingredientCartList = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "replyIngredient")
    private List<Reply> ingredientReplyList = new ArrayList<>();

    public Ingredient(String ingredientName, int ingredientPrice, String ingredientOrigin, int ingredientAmount, String ingredientUnit, int ingredientQty, List<RecipeIngredient> recipeIngredientList, IngredientCategory ingredientIngredientCategory, List<OrderDetails> ingredientOrderdetailList, List<Cart> ingredientCartList, List<Reply> ingredientReplyList) {
        this.ingredientName = ingredientName;
        this.ingredientPrice = ingredientPrice;
        this.ingredientOrigin = ingredientOrigin;
        this.ingredientAmount = ingredientAmount;
        this.ingredientUnit = ingredientUnit;
        this.ingredientQty = ingredientQty;
        this.recipeIngredientList = recipeIngredientList;
        this.ingredientIngredientCategory = ingredientIngredientCategory;
        this.ingredientOrderdetailList = ingredientOrderdetailList;
        this.ingredientCartList = ingredientCartList;
        this.ingredientReplyList = ingredientReplyList;
    }
}
