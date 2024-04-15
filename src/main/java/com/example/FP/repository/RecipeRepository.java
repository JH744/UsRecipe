package com.example.FP.repository;

import com.example.FP.entity.Ingredient;
import com.example.FP.entity.Member;
import com.example.FP.entity.Recipe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe,Long> {
    Page<Recipe> findPageBy(Pageable page);

    List<Recipe> findTop5ByOrderByRecipeViewsDesc();

    @Query(value = "select IFNULL(max(recipe_id),0)+1 from recipe", nativeQuery = true)
    Long nextRecipeId();

    @Modifying
    @Query(value = "update Recipe set recipe_views = recipe_views+1 where recipe_Id=:recipeId",nativeQuery = true)
    void UpdateRecipeViews(@Param("recipeId") Long recipeId);

//    Recipe findById();

    // 가장 조회수가 높은 회원 그룹
    @Query("SELECT r.recipeMember FROM Recipe r GROUP BY r.recipeMember ORDER BY SUM(r.recipeViews) DESC")
    List<Member> findMember();
}
