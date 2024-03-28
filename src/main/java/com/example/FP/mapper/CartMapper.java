package com.example.FP.mapper;

import com.example.FP.dto.CartDto;
import com.example.FP.dto.MemberDto;
import com.example.FP.entity.Cart;
import com.example.FP.entity.Member;
import org.springframework.stereotype.Component;

@Component
public class CartMapper {

    public static Cart toEntity(CartDto cartDto){
        Cart cart = new Cart(cartDto.getCart_member(),cartDto.getCart_recipe(),cartDto.getCart_ingredient());
        return cart;
    }
}
