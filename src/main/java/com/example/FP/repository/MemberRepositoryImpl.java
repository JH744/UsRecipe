package com.example.FP.repository;


import com.example.FP.entity.Member;
import com.example.FP.entity.QMember;
import com.querydsl.core.Tuple;
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
    public Member findByUserid(String userid) {
        return queryFactory.selectFrom(member)
                .where(userid == null ? member.userid.isNull() : member.userid.eq(userid))
                .fetchOne();
    }

    @Override
    public String findPasswordById(String userid) {
        String findPassword = queryFactory.select(member.password).from(member).where(member.userid.eq(userid)).fetchOne();
        return findPassword;

    }

    @Override
    public Member findNamePointOrderCntByUserid(String userid) {
        Tuple tuple = queryFactory.select(member.name, member.point)
                .from(member)
                .where(userid != null ? member.userid.eq(userid) : member.userid.isNull())
                .fetchOne();
        if (tuple == null) {
            return null; // 결과가 없는 경우 null 반환
        }
        String name = tuple.get(member.name);
        Integer point = tuple.get(member.point);
        return new Member(name, point);
    }
}
