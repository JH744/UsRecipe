package com.example.FP.mapper;

import com.example.FP.dto.OrderStateDto;
import com.example.FP.entity.OrderState;
import org.springframework.stereotype.Component;

@Component
public class OrderStateMapper {
    public static OrderState toEntity(OrderStateDto orderStateDto) {
        OrderState orderState = new OrderState(orderStateDto.getState(), orderStateDto.getOrders_state_list());
        return orderState;
    }
}
