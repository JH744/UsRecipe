package com.example.FP.mapper;

import com.example.FP.dto.NoticeDto;
import com.example.FP.dto.OrderDetailsDto;
import com.example.FP.entity.Notice;
import com.example.FP.entity.OrderDetails;
import org.springframework.stereotype.Component;

@Component
public class OrderDetailsMapper {
    public static OrderDetails toEntity(OrderDetailsDto orderDetailsDto){
        OrderDetails orderDetails = new OrderDetails(orderDetailsDto.getCnt(), orderDetailsDto.getOrders_detail(),orderDetailsDto.getOrders_member(),orderDetailsDto.getOrders_ingredient());
        return orderDetails;


    }
}
