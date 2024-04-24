package com.example.FP.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

import java.util.Optional;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderDetails {
    @Id
    @GeneratedValue
    @Column(name = "order_detail_id")
    private Long id;


    private int cnt;

    @ManyToOne
    @JoinColumn(name = "orders_id")
    private Orders ordersDetail;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member ordersDetailsMember;


    @ManyToOne
    @JoinColumn(name = "ingredient_id")
    private Ingredient ordersIngredient;


    public OrderDetails(int cnt, Orders ordersDetail, Member orderDetailsMember, Ingredient ordersIngredient) {

        this.cnt = cnt;
        this.ordersDetail = ordersDetail;
        this.ordersDetailsMember = orderDetailsMember;
        this.ordersIngredient = ordersIngredient;

    }


}