package com.example.FP.dto;

import com.example.FP.entity.Orders;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter@Setter
public class OrderStateDto {
    private Long id;
    private String state;
    private List<Orders> orders_state_list = new ArrayList<>();
}
