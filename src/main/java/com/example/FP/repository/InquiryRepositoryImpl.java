package com.example.FP.repository;

import com.example.FP.entity.Inquiry;
import com.example.FP.entity.QInquiry;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static com.example.FP.entity.QInquiry.inquiry;

public class InquiryRepositoryImpl implements InquiryRepositoryCustom{

    private JPAQueryFactory queryFactory ;


    public InquiryRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<Inquiry> listByUserid(String userid) {
        return queryFactory.selectFrom(inquiry).where(inquiry.inquiryMember.userid.eq(userid)).fetch();
    }
}
