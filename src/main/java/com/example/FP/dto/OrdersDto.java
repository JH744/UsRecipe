package com.example.FP.dto;

import com.example.FP.entity.Member;
import com.example.FP.entity.OrderDetails;
import com.example.FP.entity.OrderState;
import com.example.FP.entity.Point;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter@Setter
public class OrdersDto {

    private Long id;

    private LocalDateTime orders_date;
    private String orders_receiver;
    private String orders_receiver_addr;
    private String orders_receiver_phone;
    private int orders_total_price;
    private int orders_sale_price;
    private Integer orders_used_point;
    private String orders_request;
    private String orders_non_member_name;
    private String orders_non_member_phone;

    private Member orders_member;


    private List<OrderDetails> order_ordersdetail_list = new ArrayList<>();
    private OrderState orders_order_state;
    private List<Point> order_point_list = new ArrayList<>();

}
