package com.example.FP.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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

    private LocalDateTime ordersDate;
    private String ordersReceiver;
    private String ordersReceiverAddr;
    private String ordersReceiverPhone;
    private int ordersTotalPrice;
    private int ordersSalePrice;
    private int ordersUsedPoint;
    private String ordersRequest;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member ordersMember;


    @ManyToOne
    @JoinColumn(name = "order_state_id")
    private OrderState ordersOrderState;

    @Builder.Default
    @OneToMany(mappedBy = "ordersDetail")
    private List<OrderDetails> orderOrdersdetailList = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "pointOrders")
    private List<Point> orderPointList = new ArrayList<>();



    public Orders(LocalDateTime orders_date,
                  String orders_receiver,
                  String orders_receiver_addr,
                  String orders_receiver_phone,
                  int orders_total_price,
                  int orders_sale_price,
                  Integer orders_used_point,
                  String orders_request,
                  Member orders_member,
                  List<OrderDetails> order_ordersdetail_list,
                  OrderState orders_order_state,
                  List<Point> orders_point_list
    ) {

        this.ordersDate = orders_date;
        this.ordersReceiver = orders_receiver;
        this.ordersReceiverAddr = orders_receiver_addr;
        this.ordersReceiverPhone = orders_receiver_phone;
        this.ordersTotalPrice = orders_total_price;
        this.ordersSalePrice = orders_sale_price;
        this.ordersUsedPoint = orders_used_point;
        this.ordersRequest = orders_request;
        this.ordersMember = orders_member;
        this.orderOrdersdetailList = order_ordersdetail_list;
        this.ordersOrderState = orders_order_state;
        this.orderPointList = orders_point_list;

    }
}
