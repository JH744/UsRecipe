package com.example.FP.service;

import com.example.FP.dto.OrdersDto;
import com.example.FP.entity.OrderDetails;
import com.example.FP.entity.Orders;
import com.example.FP.repository.OrderDetailsRepository;
import com.example.FP.repository.OrdersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrdersService {
    private final OrdersRepository or;
    private final OrderDetailsRepository odr;

    public List<Orders> findAllOrderListByUserid(String userid){
        return or.findOrdersListByUserid(userid);
    }
    public List<OrderDetails> findByOrderId(Long id){
        return odr.findByOrderId(id);
    }

    public List<Orders> findAll(){ return or.findAll(); }

    public void save(Orders o) {
            or.save(o);
    }
}
