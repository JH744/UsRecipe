package com.example.FP.mapper;

import com.example.FP.dto.NoticeDto;
import com.example.FP.dto.OrdersDto;
import com.example.FP.entity.Notice;
import com.example.FP.entity.Orders;
import org.springframework.stereotype.Component;

@Component
public class OrdersMapper {
    public static Orders toEntity(OrdersDto ordersDto){
        Orders orders = new Orders(ordersDto.getOrders_date(), ordersDto.getOrders_receiver(), ordersDto.getOrders_receiver_addr(), ordersDto.getOrders_receiver_phone(), ordersDto.getOrders_total_price(), ordersDto.getOrders_sale_price(), ordersDto.getOrders_used_point(), ordersDto.getOrders_request(), ordersDto.getOrders_non_member_name(), ordersDto.getOrders_non_member_phone(), ordersDto.getOrders_member(),ordersDto.getOrder_ordersdetail_list(), ordersDto.getOrders_order_state());
        return orders;

    }
}
