package com.example.FP.repository;


import com.example.FP.entity.QMember;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;

import static com.example.FP.entity.QMember.member;

public class MemberRepositoryImpl implements MemberRepositoryCustom{

    private final JPAQueryFactory queryFactory;


    @Autowired
    public MemberRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);

    }

    @Override
    public String findPasswordById(String userid) {
        String findPassword = queryFactory.select(member.password).from(member).where(member.userid.eq(userid)).fetchOne();
        return findPassword;

    }
}
