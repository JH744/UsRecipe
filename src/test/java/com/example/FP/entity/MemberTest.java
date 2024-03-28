package com.example.FP.entity;

import com.example.FP.dto.MemberDto;
import com.example.FP.mapper.MemberMapper;
import com.example.FP.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberTest {

    @Autowired
    private MemberRepository mr;

    @Test
    public void dtoTest(){
        MemberDto memberDto = new MemberDto("userid","aaa","kim","nick");
        Member member = MemberMapper.toEntity(memberDto);
        mr.save(member);

        System.out.println(member.getUserid());
        System.out.println(member.getPassword());
        System.out.println(member.getName());
        System.out.println(member.getNickname());




    }

}