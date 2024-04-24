package com.example.FP.repository;

import com.example.FP.entity.Member;
import com.example.FP.entity.OrderDetails;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;

import java.util.List;

import static com.example.FP.entity.QOrderDetails.orderDetails;

public class OrderDetailsRepositoryImpl implements OrderDetailsCustom {

    private JPAQueryFactory queryFactory;

    public OrderDetailsRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<OrderDetails> findByOrderId(Long id) {
        return queryFactory.selectFrom(orderDetails).where(orderDetails.ordersDetail.id.eq(id)).fetch();
    }

    @Override
    public Member buyMember(Long id) {
        return queryFactory.select(orderDetails.ordersDetailsMember).from(orderDetails).where(orderDetails.ordersDetailsMember.id.eq(id)).fetchOne();
    }
}

