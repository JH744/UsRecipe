package com.example.FP.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class IngredientCategory {
    @Id@GeneratedValue
    @Column(name = "ingredient_category_id")
    private Long id;

    private String ingredient_category_name;

    @OneToMany(mappedBy = "ingredient_ingredient_category")
    private List<Ingredient> ingredient_list;
}
