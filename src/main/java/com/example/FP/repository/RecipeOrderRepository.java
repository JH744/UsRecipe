package com.example.FP.repository;

import com.example.FP.entity.Recipe;
import com.example.FP.entity.RecipeOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface RecipeOrderRepository extends JpaRepository<RecipeOrder, Long> {

    @Query(value = "select max(recipe_order_id) from recipe_order where recipe_id=?1",nativeQuery = true)
    Long PreviousRecipeOrderMaxId(Long recipe_id);
    @Modifying
    @Query(value = "delete from recipe_order where recipe_id=?1 and recipe_order_id<=?2",nativeQuery = true)
    void deleteAllByPreviousRecipeOrder(Long recipe_id,Long recipe_order_id);
}
