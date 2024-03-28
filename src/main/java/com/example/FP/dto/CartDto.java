package com.example.FP.dto;

import com.example.FP.entity.Ingredient;
import com.example.FP.entity.Member;
import com.example.FP.entity.Recipe;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class CartDto {

    private Long id;

    private Member cart_member;

    private Recipe cart_recipe;

    private Ingredient cart_ingredient;
}
