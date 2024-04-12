package com.example.FP.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.springframework.web.multipart.MultipartFile;

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
    private String ingredientImage;
    private String ingredientDetail;

    @Transient
    private MultipartFile uploadFile;


    @ManyToOne
    @JoinColumn(name = "ingredient_category_id")
    private IngredientCategory ingredientIngredientCategory;

    public Ingredient(String ingredientName, int ingredientPrice, String ingredientOrigin, int ingredientAmount, String ingredientUnit, int ingredientQty, String ingredientImage, String ingredientDetail, IngredientCategory ingredientIngredientCategory) {
        this.ingredientName = ingredientName;
        this.ingredientPrice = ingredientPrice;
        this.ingredientOrigin = ingredientOrigin;
        this.ingredientAmount = ingredientAmount;
        this.ingredientUnit = ingredientUnit;
        this.ingredientQty = ingredientQty;
        this.ingredientImage = ingredientImage;
        this.ingredientDetail = ingredientDetail;
        this.ingredientIngredientCategory = ingredientIngredientCategory;
    }
}