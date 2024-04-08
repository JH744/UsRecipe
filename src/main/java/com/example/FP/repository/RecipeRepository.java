package com.example.FP.repository;

import com.example.FP.entity.Ingredient;
import com.example.FP.entity.Recipe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe,Long> {



    Page<Recipe> findPageBy(Pageable page);
}
