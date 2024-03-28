package com.example.FP.mapper;

import com.example.FP.dto.NoticeDto;
import com.example.FP.dto.WishListDto;
import com.example.FP.entity.Notice;
import com.example.FP.entity.WishList;
import org.springframework.stereotype.Component;

@Component
public class WishListMapper {
    public static WishList toEntity(WishListDto wishListDto){
        WishList wishList = new WishList(wishListDto.getId(), wishListDto.getWishlist_member(),wishListDto.getWishlist_recipe());
        return wishList;


    }
}
