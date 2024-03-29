package com.example.FP.repository;

import com.example.FP.entity.RecipeOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeOrderRepository extends JpaRepository<RecipeOrder, Long> {
}
