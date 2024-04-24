package com.example.FP.entity;

import com.example.FP.dto.MemberDto;
import com.example.FP.mapper.MemberMapper;
import com.example.FP.repository.MemberRepository;
import com.example.FP.repository.WishListRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(value = false)
class WishListTest {

    private WishListRepository wr;
    private MemberRepository mr;

    @Autowired
    public WishListTest(WishListRepository wr, MemberRepository mr) {
        this.wr = wr;
        this.mr = mr;
    }

    @Test
    public void insertWishlist(){

        MemberDto member4 = new MemberDto("aaa","aaa","aaa","aaa","aaa","aaa@naver.com","010-1111-2222",0,"1997-03-24",null);
        MemberDto member5 = new MemberDto("bbb","bbb","bbb","bbb","bbb","bbb@naver.com","010-3333-4444",0,"1997-03-25",null);
        MemberDto member6 = new MemberDto("ccc","ccc","ccc","ccc","ccc","ccc@naver.com","010-5555-6666",0,"1997-03-25",null);
        Member member1 = MemberMapper.toEntity(member4);
        Member member2 = MemberMapper.toEntity(member5);
        Member member3 = MemberMapper.toEntity(member6);
        mr.save(member1);
        mr.save(member2);
        mr.save(member3);

        WishList wishList = new WishList(member1,null);
        wr.save(wishList);
    }

}