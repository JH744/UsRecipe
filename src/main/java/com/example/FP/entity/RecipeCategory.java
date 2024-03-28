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
    @Column(name = "recipe_category_id")
    private Long id;

    private String recipe_category_name;

    @Builder.Default
    @OneToMany(mappedBy = "recipe_category")
    private List<Recipe> recipe_list = new ArrayList<>();

    public RecipeCategory(String recipe_category_name, List<Recipe> recipe_list) {
        this.recipe_category_name = recipe_category_name;
        this.recipe_list = recipe_list;
    }
}
