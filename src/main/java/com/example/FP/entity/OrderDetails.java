package com.example.FP.entity;

import jakarta.persistence.*;

@Entity
public class OrderDetails {
    @Id@GeneratedValue
    @Column(name = "order_detail_id")
    private Long id;

    private int ingredient_price;

    @ManyToOne
    @JoinColumn(name = "orders_id")
    private Orders orders_detail;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member orders_member;

    @ManyToOne
    @JoinColumn(name = "ingredient_id")
    private Ingredient orders_ingredient;




}
