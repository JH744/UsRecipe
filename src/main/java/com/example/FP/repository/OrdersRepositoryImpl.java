package com.example.FP.repository;

import com.example.FP.entity.*;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.example.FP.entity.QIngredient.ingredient;
import static com.example.FP.entity.QOrderDetails.orderDetails;
import static com.example.FP.entity.QOrders.orders;

public class OrdersRepositoryImpl implements OrdersRepositoryCustom {

    private JPAQueryFactory queryFactory;

    public OrdersRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<Orders> findOrdersListByUserid(String userid) {
        return queryFactory.select(orders)
                .from(orders)
                .where(userid != null ? orders.ordersMember.userid.eq(userid) : orders.ordersMember.userid.isNull())
                .fetch();
    }

    public List<Orders> findByOrderState(String orderStateString) {
        OrderState orderState = OrderState.valueOf(orderStateString);
        return queryFactory
                .selectFrom(orders)
                .where(orders.ordersOrderState.eq(orderState))
                .fetch();
    }

    @Override
    @Transactional
    public void updateState(Long id) {
        queryFactory.update(orders).set(orders.ordersOrderState,OrderState.cancel).where(orders.id.eq(id)).execute();
    }

    public Member cancelOrderMember(Long id){
        return queryFactory.select(orders.ordersMember).from(orders).where(orders.id.eq(id)).fetchOne();
    }
}
