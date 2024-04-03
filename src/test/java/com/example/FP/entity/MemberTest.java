package com.example.FP.entity;

import com.example.FP.dto.MemberDto;
import com.example.FP.mapper.MemberMapper;
import com.example.FP.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
//@Rollback(value = false)
class MemberTest {
    private final MemberRepository mr;

    @Autowired
    public MemberTest(MemberRepository mr) {
        this.mr = mr;
    }

    @Test
    public void joinMember() {
        MemberDto member4 = new MemberDto("aaa","aaa","aaa","aaa","aaa","aaa@naver.com","010-1111-2222",1,"1997-03-24");
        MemberDto member5 = new MemberDto("bbb","bbb","bbb","bbb","bbb","bbb@naver.com","010-3333-4444",2,"1997-03-25");
        MemberDto member6 = new MemberDto("ccc","ccc","ccc","ccc","ccc","ccc@naver.com","010-5555-6666",3,"1997-03-25");
        Member member1 = MemberMapper.toEntity(member4);
        Member member2 = MemberMapper.toEntity(member5);
        Member member3 = MemberMapper.toEntity(member6);
        mr.save(member1);
        mr.save(member2);
        mr.save(member3);

//        System.out.println(member1.getRole());
//        assertThat(member1.getName()).isEqualTo("aaa");
        assertThat(member1.getRole()).isEqualTo(MemberRole.MEMBER);
    }
}