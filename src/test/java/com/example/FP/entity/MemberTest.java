package com.example.FP.entity;

import com.example.FP.dto.MemberDto;
import com.example.FP.mapper.MemberMapper;
import com.example.FP.repository.MemberRepository;
import com.example.FP.repository.RecipeRepository;
import com.example.FP.repository.WishListRepository;
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


//    @Autowired
//    MemberRepository memberRepository;
//    @Autowired
//    RecipeRepository recipeRepository;
//
//    @Autowired
//    WishListRepository wishListRepository;
//    @Test
//    public void methodTest(){
//
//        MemberDto memberDto = new MemberDto("aaa","bbb","ccc","ddd");
//        Member member = MemberMapper.toEntity(memberDto);
//        Recipe recipe = new Recipe("title");
//
//        memberRepository.save(member);
//        recipeRepository.save(recipe);
//
//
//        WishList wishList= WishList.createCart(recipe,member);
//        wishListRepository.save(wishList);
//
//        System.out.println(wishList.getWishlist_member().getUserid());
//        System.out.println(wishList.getWishlist_member().getPassword());
//        System.out.println(wishList.getWishlist_member().getNickname());
//        System.out.println(wishList.getWishlist_member().getName());
//
//    }

//    @Test
//    public void dtoTest(){
//        MemberDto memberDto = new MemberDto("userid","aaa","kim","nick");
//        Member member = MemberMapper.toEntity(memberDto);
//        mr.save(member);
//
//        System.out.println(member.getUserid());
//        System.out.println(member.getPassword());
//        System.out.println(member.getName());
//        System.out.println(member.getNickname());
//
//
//
//
//    }

}