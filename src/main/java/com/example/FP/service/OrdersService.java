package com.example.FP.service;

import com.example.FP.entity.Orders;
import com.example.FP.repository.OrdersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrdersService {
    private final OrdersRepository or;

    public List<Orders> findAllOrderListByUserid(String userid){
        return or.findOrdersListByUserid(userid);
    }


}
