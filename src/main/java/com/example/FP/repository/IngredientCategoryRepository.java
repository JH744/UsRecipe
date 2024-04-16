package com.example.FP.repository;

import com.example.FP.entity.IngredientCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientCategoryRepository extends JpaRepository<IngredientCategory,Long> {
}
