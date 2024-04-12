package com.example.FP.repository;

import com.example.FP.dto.InquiryDto;
import com.example.FP.entity.Inquiry;
import com.example.FP.entity.InquiryState;
import com.example.FP.entity.QInquiry;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
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

    @Override
    public List<Inquiry> listInquiryAnswerYet() {
        return queryFactory.selectFrom(inquiry).where(inquiry.inquiryState.eq(InquiryState.NO)).fetch();
    }

    @Override
    public List<Inquiry> listInquiryAnswered() {
        return queryFactory.selectFrom(inquiry).where(inquiry.inquiryState.eq(InquiryState.YES)).fetch();
    }

    @Override
    @Transactional
    public void updateInquiry(Long id) {
        queryFactory.update(inquiry).set(inquiry.inquiryState,InquiryState.YES).set(inquiry.inquiryAnswerDate, LocalDateTime.now()).where(inquiry.id.eq(id)).execute();
    }
}
