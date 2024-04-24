package com.example.FP.mapper;

import com.example.FP.dto.MemberDto;
import com.example.FP.entity.Member;
import org.springframework.stereotype.Component;

@Component
public class MemberMapper {

    public static Member toEntity(MemberDto memberDto){
        Member member = new Member(memberDto.getUserid(), memberDto.getPassword(), memberDto.getName(), memberDto.getNickname(), memberDto.getAddr(), memberDto.getEmail(), memberDto.getPhone(), memberDto.getPoint(), memberDto.getBirth(), memberDto.getRole(),memberDto.getInquiry_list(),memberDto.getWishlist_list(),memberDto.getRecipe_list(),memberDto.getOrder_member_list(),memberDto.getMember_cart_list(),memberDto.getMember_reply_list(), memberDto.getMember_alarm_list(),memberDto.getMember_point_list(),memberDto.getMember_orders_list(), memberDto.getImage());
        return member;
    }
}
