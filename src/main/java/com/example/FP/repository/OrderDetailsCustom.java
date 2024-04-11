package com.example.FP.repository;

import com.example.FP.entity.OrderDetails;

import java.util.List;

public interface OrderDetailsCustom {

    List<OrderDetails> findByOrderId(Long id);
}
