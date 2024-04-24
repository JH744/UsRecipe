package com.example.FP.repository;

import com.example.FP.entity.RecipeCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecipeCategoryRepository extends JpaRepository<RecipeCategory,Long> {
}
