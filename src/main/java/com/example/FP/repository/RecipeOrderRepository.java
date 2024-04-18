package com.example.FP.repository;

import com.example.FP.entity.Recipe;
import com.example.FP.entity.RecipeOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface RecipeOrderRepository extends JpaRepository<RecipeOrder, Long> {

    @Modifying
    @Query(value = "delete from recipe_order where recipe_id=?1",nativeQuery = true)
    void deleteAllByPreviousRecipeOrder(Long recipe_id);
}
