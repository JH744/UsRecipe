package com.example.FP.service;

import com.example.FP.dto.OrdersDto;
import com.example.FP.entity.Member;
import com.example.FP.entity.OrderDetails;
import com.example.FP.entity.Orders;
import com.example.FP.mapper.OrdersMapper;
import com.example.FP.repository.OrderDetailsRepository;
import com.example.FP.repository.OrdersRepository;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrdersService {
    private final OrdersRepository or;
    private final OrderDetailsRepository odr;
    private final MemberService ms;

    public List<Orders> findAllOrderListByUserid(String userid){
        return or.findOrdersListByUserid(userid);
    }
    public List<OrderDetails> findByOrderId(Long id){
        return odr.findByOrderId(id);
    }

    public List<Orders> findAll(){ return or.findAll(); }




    public void save(OrdersDto o, HttpSession session) {

        // 현재 날짜와 시간을 가져옵니다.
        LocalDateTime currentDateTime = LocalDateTime.now();
        // 'yyyy-MM-dd'T'HH:mm' 형식의 포매터를 생성합니다.
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        // 현재 날짜와 시간을 지정된 포맷으로 문자열로 변환합니다.
        String formattedDateTime = currentDateTime.format(formatter);
        o.setOrders_date(LocalDateTime.parse(formattedDateTime));

        //현재 로그인 회원 정보가져와 집어넣음
        Member userid = ms.findById((String) session.getAttribute("userid"));

        int usedPoint = 0;
        if (o.getOrders_used_point() != null){
            usedPoint = o.getOrders_used_point();
        }
        o.setOrders_used_point(usedPoint);
        o.setOrders_member(userid);


        or.save(OrdersMapper.toEntity(o));
    }
}
