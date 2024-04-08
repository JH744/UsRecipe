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
public class RecipeCategory {
    @Id@GeneratedValue
    @Column(name = "recipeCategory_id")
    private Long id;

    private String recipeCategoryName;

    @Builder.Default
    @OneToMany(mappedBy = "recipeCategory")
    private List<Recipe> recipeList = new ArrayList<>();

    public RecipeCategory(String recipeCategoryName, List<Recipe> recipeList) {
        this.recipeCategoryName = recipeCategoryName;
        this.recipeList = recipeList;
    }
}
