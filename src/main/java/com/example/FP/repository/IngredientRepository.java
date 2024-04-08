package com.example.FP.repository;

import com.example.FP.entity.Ingredient;
import com.example.FP.entity.Recipe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IngredientRepository extends JpaRepository<Ingredient,Long> {

    //재료목록 전체 불러오기
    Page<Ingredient> findAll(Pageable pageable);

    //제료목록 카테고리id별로 불러오기
    @Query("SELECT i FROM Ingredient i WHERE (:categoryId IS NULL OR i.ingredientIngredientCategory.id = :categoryId)")
    Page<Ingredient> findByCategoryId(@Param("categoryId") Long categoryId, Pageable pageable);

}
