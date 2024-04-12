package com.example.FP.repository;

import com.example.FP.entity.Ingredient;
import com.example.FP.entity.IngredientCategory;
import com.example.FP.entity.QIngredient;
import com.example.FP.entity.QIngredientCategory;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;

import java.util.List;

import static com.example.FP.entity.QIngredient.ingredient;
import static com.example.FP.entity.QIngredientCategory.ingredientCategory;

public class IngredientRepositoryImpl implements IngredientRepositoryCustom{

    private JPAQueryFactory queryFactory;

    public IngredientRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<IngredientCategory> findAllIngredientCategory() {
        List<IngredientCategory> list = queryFactory.selectFrom(ingredientCategory).fetch();
        return list;

    }
}
