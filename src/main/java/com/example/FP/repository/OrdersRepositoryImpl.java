package com.example.FP.repository;

import com.example.FP.entity.*;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;

import java.util.List;

import static com.example.FP.entity.QIngredient.ingredient;
import static com.example.FP.entity.QOrderDetails.orderDetails;
import static com.example.FP.entity.QOrders.orders;

public class OrdersRepositoryImpl implements OrdersRepositoryCustom {

    private JPAQueryFactory queryFactory;

    public OrdersRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }




}
