package com.example.FP.service;

import com.example.FP.dto.OrdersDto;

import com.example.FP.entity.*;
import com.example.FP.mapper.OrdersMapper;
import com.example.FP.repository.IngredientRepository;
import com.example.FP.repository.OrderDetailsRepository;
import com.example.FP.repository.OrdersRepository;
import com.example.FP.repository.PointRepository;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrdersService {
    private final OrdersRepository or;
    private final OrderDetailsRepository odr;
    private final PointRepository pr;
    private final IngredientRepository ir;
    private final MemberService ms;


    public List<Orders> findAllOrderListByUserid(String userid){
        return or.findOrdersListByUserid(userid);
    }
    public List<OrderDetails> findByOrderId(Long id){
        return odr.findByOrderId(id);
    }

    public List<Orders> findAll(){ return or.findAll(); }

    public List<Orders> findByOrderState(String orderState){
        if (orderState == null || orderState.equals("all")){
            return or.findAll();
        }
        return or.findByOrderState(orderState);
    }




//    public void save(OrdersDto o, HttpSession session) {
//
//        // 현재 날짜와 시간을 가져옵니다.
//        LocalDateTime currentDateTime = LocalDateTime.now();
//        // 'yyyy-MM-dd'T'HH:mm' 형식의 포매터를 생성합니다.
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
//        // 현재 날짜와 시간을 지정된 포맷으로 문자열로 변환합니다.
//        String formattedDateTime = currentDateTime.format(formatter);
//        o.setOrders_date(LocalDateTime.parse(formattedDateTime));
//
//        //현재 로그인 회원 정보가져와 집어넣음
//        Member userid = ms.findById((String) session.getAttribute("userid"));
//
//        int usedPoint = 0;
//        if (o.getOrders_used_point() != null){
//            usedPoint = o.getOrders_used_point();
//        }
//        o.setOrders_used_point(usedPoint);
//        o.setOrders_member(userid);
//
//
//        or.save(OrdersMapper.toEntity(o));
//    }

    public Orders saveOrders(Orders o, Member m){
        Orders orders = new Orders();

        return orders.createOreders(o, m);


    }

    public void saveOrder(Orders o){
        or.save(o);
    }

    public void changeState(Long id){
        or.updateState(id);
    }


    public Member buyMember(Long id){
        return odr.buyMember(id);
    }


    public void saveOrderDetails(HttpSession session){
        // 회원이 막 주문했을 주문목록 가져옴.
        Member m = ms.findById((String) session.getAttribute("userid"));
        List<Orders> o = or.findLatestOrderByMemberIdWithHighestId(m.getId());
        if (!o.isEmpty()) {

            Orders latestOrder = o.get(0);  // 첫 번째 결과를 선택, 정렬이 중요함
            System.out.println(latestOrder.getId());
            // 필요한 로직 수행
        } else {
            // 결과가 없는 경우의 처리 로직
        }

        // 구매물품들 목록을 가져옴
        List<Map<String, Object>> products = (List<Map<String, Object>>) session.getAttribute("products");
        // 물품의 갯수만큼 주문상세 내역 저장함
        for (Map<String, Object> product : products) {
                String ingredientName = (String) product.get("name");
            System.out.println(ingredientName);
                String quantity = (String) product.get("quantity");
            System.out.println(quantity);
                int cnt = Integer.parseInt(quantity);
                Ingredient i = ir.findByIngredientName(ingredientName);

                OrderDetails od = new OrderDetails();
                od.setCnt(cnt);
                od.setOrdersDetail(o.get(0));
                od.setOrdersDetailsMember(m);
                od.setOrdersIngredient(i);
                odr.save(od);
            }
        }
    }


