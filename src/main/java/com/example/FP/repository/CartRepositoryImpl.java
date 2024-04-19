package com.example.FP.repository;

import com.example.FP.entity.Cart;
import com.example.FP.entity.QCart;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static com.example.FP.entity.QCart.cart;

public class CartRepositoryImpl implements CartRepositoryCustom{

    private JPAQueryFactory queryFactory;

    public CartRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<Cart> findByUserid(String userid) {
         return queryFactory.selectFrom(cart).where(cart.cartMember.userid.eq(userid)).fetch();
    }
}
