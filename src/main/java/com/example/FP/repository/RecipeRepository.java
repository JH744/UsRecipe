package com.example.FP.repository;

import com.example.FP.entity.Ingredient;
import com.example.FP.entity.Recipe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe,Long> {
    Page<Recipe> findPageBy(Pageable page);

    List<Recipe> findTop5ByOrderByRecipeViewsDesc();

    // 가장 조회수가 높은 회원 그룹
//    List<Recipe> findByRecipeMemberIdGroupByRecipeMemberIdOrderByRecipeViewsDesc();
}
