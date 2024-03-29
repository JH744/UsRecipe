package com.example.FP.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderState {

    @Id@GeneratedValue
    @Column(name = "order_state_id")
    private Long id;
    private String state;

    @Builder.Default
    @OneToMany(mappedBy = "orders_order_state")
    private List<Orders> orders_state_list = new ArrayList<>();

    public OrderState(String state, List<Orders> orders_state_list) {
        this.state = state;
        this.orders_state_list = orders_state_list;
    }
}
