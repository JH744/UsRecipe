package com.example.FP.controller;

import com.example.FP.dto.OrdersDto;
import com.example.FP.entity.Member;
import com.example.FP.entity.OrderState;
import com.example.FP.entity.Orders;
import com.example.FP.entity.Point;
import com.example.FP.mapper.OrdersMapper;
import com.example.FP.service.MemberService;
import com.example.FP.service.OrdersService;
import com.example.FP.service.PointService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Controller
@RequiredArgsConstructor
public class OrdersController {
    private final OrdersService os;
    private final MemberService ms;
    private final PointService ps;

    @GetMapping("/order")
    public String orderPage(Model model,HttpSession session){

        //String id = "asd123"; // 임시 id
       String id = (String) session.getAttribute("userid");
       Member m =  ms.findById(id);
        System.out.println("가져온 회원객체 :"+m);

        model.addAttribute("m", ms.findById(id));

        return "/user/orderPage";
    }


    @PostMapping("/orderOK")
    public String orderOK(OrdersDto o, HttpSession session){
        System.out.println("가져온 결제자명:" + o.getOrders_receiver());
        // 현재 날짜와 시간을 가져옵니다.
        LocalDateTime currentDateTime = LocalDateTime.now();
        // 'yyyy-MM-dd'T'HH:mm' 형식의 포매터를 생성합니다.
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        // 현재 날짜와 시간을 지정된 포맷으로 문자열로 변환합니다.
        String formattedDateTime = currentDateTime.format(formatter);
        o.setOrders_date(LocalDateTime.parse(formattedDateTime));

        Orders orders = os.saveOrders(OrdersMapper.toEntity(o), ms.findById((String) session.getAttribute("userid")));

        os.saveOrder(orders);
        if(orders.getOrdersUsedPoint()!=0){
            Point point = new Point(orders.getOrdersUsedPoint(),"구매에 의한 차감",ms.findById((String)session.getAttribute("userid")),orders);
            ps.savePoint(point);
        }
        Point point = new Point((int)Math.round(orders.getOrdersSalePrice()*0.01),"구매에 의한 적립",ms.findById((String)session.getAttribute("userid")),orders);
        ps.savePoint(point);




        return "/user/orderOK";

    }



    @GetMapping("/orderList")
    public String orderList(Model model, HttpSession session){
        model.addAttribute("list",os.findAllOrderListByUserid((String)session.getAttribute("userid")));
        model.addAttribute("info",ms.listPointAndNameByUserid((String)session.getAttribute("userid")));


        return "/user/orderList";

    }

    //회원별 주문목록 상세화면 출력을 위한 메서드
    @GetMapping("/orderDetail/{id}")
    public String orderDetail(Model model, @PathVariable Long id){

        model.addAttribute("list",os.findByOrderId(id));

        return "/user/orderListDetail";

    }



    //관리자페이지에서 주문전체목록 출력을 위한 메서드
    @GetMapping("/adminOrderList")
    public String adminOrderList(Model model){
        model.addAttribute("list", os.findAll());
        return "/admin/adminOrdersList";
    }


}
