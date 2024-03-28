package com.example.FP.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class IngredientCategory {
    @Id@GeneratedValue
    @Column(name = "ingredient_category_id")
    private Long id;

    private String ingredient_category_name;

    @OneToMany(mappedBy = "ingredient_ingredient_category")
    private List<Ingredient> ingredient_list;
}
