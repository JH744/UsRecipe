package com.example.FP.dto;

import com.example.FP.entity.Member;
import com.example.FP.entity.Orders;
import com.example.FP.entity.Point;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PointDto {
    
    private Long id;
    private int use_point;
    private String point_content;
    private Member point_member;
    private Orders point_orders;



}
