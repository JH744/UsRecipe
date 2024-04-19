package com.example.FP.dto;

import com.example.FP.entity.Ingredient;
import com.example.FP.entity.Member;
import com.example.FP.entity.Orders;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class OrderDetailsDto {

    private Long id;

    private int cnt;


    private Orders orders_detail;


    private Member orders_member;


    private Ingredient orders_ingredient;

}
