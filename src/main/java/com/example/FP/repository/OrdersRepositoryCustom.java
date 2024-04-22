package com.example.FP.repository;

import com.example.FP.entity.Member;
import com.example.FP.entity.OrderState;
import com.example.FP.entity.Orders;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRepositoryCustom {
    List<Orders> findOrdersListByUserid(String userid);
    List<Orders> findByOrderState(String orderState);
    void updateState(Long id);
    Member cancelOrderMember(Long id);




}
