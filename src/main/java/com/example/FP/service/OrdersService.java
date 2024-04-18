package com.example.FP.service;

import com.example.FP.dto.OrdersDto;
import com.example.FP.entity.*;
import com.example.FP.repository.OrderDetailsRepository;
import com.example.FP.repository.OrdersRepository;
import com.example.FP.repository.PointRepository;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrdersService {
    private final OrdersRepository or;
    private final OrderDetailsRepository odr;
    private final PointRepository pr;

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

    public Orders saveOrders(Orders o, Member m, OrderState os){
        Orders orders = new Orders();
        orders.createOreders(o,m,os);
        if(o.getOrdersUsedPoint()!=0){
            Point point = new Point(o.getOrdersUsedPoint(),"상품구매에 의한 차감",m,o);
            pr.save(point);
        }
        Point point = new Point((int)Math.round(o.getOrdersSalePrice()*0.01),"구매에 의한 적립",m,o);
        pr.save(point);
        return orders;

    }
}
