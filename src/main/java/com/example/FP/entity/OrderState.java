package com.example.FP.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class OrderState {

    @Id@GeneratedValue
    @Column(name = "order_state_id")
    private Long id;
    private String state;

    @Builder.Default
    @OneToMany(mappedBy = "ordersOrderState")
    private List<Orders> ordersStateList = new ArrayList<>();

    public OrderState(String state, List<Orders> orders_state_list) {
        this.state = state;
        this.ordersStateList = orders_state_list;
    }
}
