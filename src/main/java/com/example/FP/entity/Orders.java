package com.example.FP.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Orders {
    @Id
    @GeneratedValue
    @Column(name = "orders_id")
    private Long id;

    private LocalDateTime orders_date;
    private String orders_receiver;
    private String orders_receiver_addr;
    private String orders_receiver_phone;
    private int orders_total_price;
    private int orders_sale_price;
    private int orders_used_point;
    private String orders_request;
    private String orders_non_member_name;
    private String orders_non_member_phone;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member orders_member;

    @OneToMany(mappedBy = "orders_detail")
    private List<OrderDetails> order_ordersdetail_list = new ArrayList<>();

}
