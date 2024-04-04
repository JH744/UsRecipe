package com.example.FP.entity;

import com.example.FP.dto.MemberDto;
import com.example.FP.mapper.MemberMapper;
import com.example.FP.repository.MemberRepository;
import com.example.FP.repository.OrdersRepository;
import com.example.FP.service.MemberService;
import com.example.FP.service.OrdersService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class OrdersTest {


    private MemberRepository mr;
    private OrdersRepository or;


    private MemberService ms;
    private OrdersService os;

    @Autowired
    public OrdersTest(MemberRepository mr, OrdersRepository or, MemberService ms, OrdersService os) {
        this.mr = mr;
        this.or = or;
        this.ms = ms;
        this.os = os;
    }



    @Test
    public void orderTest(){
        MemberDto member4 = new MemberDto("aaa","aaa","aaa","aaa","aaa","aaa@naver.com","010-1111-2222",0,"1997-03-24",null);
        MemberDto member5 = new MemberDto("bbb","bbb","bbb","bbb","bbb","bbb@naver.com","010-3333-4444",0,"1997-03-25",null);
        MemberDto member6 = new MemberDto("ccc","ccc","ccc","ccc","ccc","ccc@naver.com","010-5555-6666",0,"1997-03-25",null);
        Member member1 = MemberMapper.toEntity(member4);
        Member member2 = MemberMapper.toEntity(member5);
        Member member3 = MemberMapper.toEntity(member6);
        mr.save(member1);
        mr.save(member2);
        mr.save(member3);

        LocalDateTime time = LocalDateTime.now();
        Orders orders = new Orders(time,"kim","seoul",null,20000,48500,0,null,member1,null,null,null);

        or.save(orders);

        member1.addPoint(orders);

        assertThat(member1.getPoint()).isEqualTo(485);


    }

}