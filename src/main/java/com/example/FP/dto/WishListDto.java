package com.example.FP.dto;

import com.example.FP.entity.Member;
import com.example.FP.entity.Recipe;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class WishListDto {

    private Long id;


    private Member wishlist_member;


    private Recipe wishlist_recipe;
}
