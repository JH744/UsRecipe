package com.example.FP.repository;

import com.example.FP.entity.Orders;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRepositoryCustom {
    List<Orders> listOrders(String userid);

}
