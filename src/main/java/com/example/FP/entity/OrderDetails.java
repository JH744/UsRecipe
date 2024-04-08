package com.example.FP.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
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
    private Member ordersMember;

    @ManyToOne
    @JoinColumn(name = "ingredient_id")
    private Ingredient orders_ingredient;


    public OrderDetails(int ingredient_price, Orders orders_detail, Member orders_member, Ingredient orders_ingredient) {
        this.ingredient_price = ingredient_price;
        this.orders_detail = orders_detail;
        this.ordersMember = orders_member;
        this.orders_ingredient = orders_ingredient;
    }
}
