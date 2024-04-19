package com.example.FP.controller;

import com.example.FP.dto.OrdersDto;
import com.example.FP.entity.Member;
import com.example.FP.entity.Orders;
import com.example.FP.mapper.OrdersMapper;
import com.example.FP.service.MemberService;
import com.example.FP.service.OrdersService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.WebUtils;
import org.thymeleaf.standard.expression.Each;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class OrdersController {
    private final OrdersService os;
    private final MemberService ms;


    @GetMapping("/order")
    public String orderPage(Model model,HttpSession session){

        //String id = "asd123"; // 임시 id
       String id = (String) session.getAttribute("userid");
       Member m =  ms.findById(id);
        System.out.println("가져온 회원객체 :"+m);

        model.addAttribute("m", ms.findById(id));

        return "orderPage";
    }


    @PostMapping("/orderOK")
    public String orderOK(OrdersDto o, HttpSession session) {
        System.out.println("가져온 결제자명:" + o.getOrders_receiver());


        os.save(o,session);
        return "orderOK";
    }


    //구매물품들의 상품명,수량,금액을 저장함
    @PostMapping("/orderSave")
    public String orderOK(@RequestBody Map<String, List<Map<String, Object>>> payload, HttpSession session){

        List<Map<String, Object>> products = payload.get("products");
        products.forEach(product -> {
            System.out.println("Product Name: " + product.get("name"));
            System.out.println("Quantity: " + product.get("quantity"));
            System.out.println("Price: " + product.get("price"));
        });
        session.setAttribute("products",products); // 구매품목들을 세션에 저장
        return "상품정보를 저장함";
    }






    @GetMapping("/orderList")
    public String orderList(Model model, HttpSession session){
        model.addAttribute("list",os.findAllOrderListByUserid((String)session.getAttribute("userid")));
        model.addAttribute("info",ms.listPointAndNameByUserid((String)session.getAttribute("userid")));


        return "/orderList";

    }

    @GetMapping("/orderDetail/{id}")
    public String orderDetail(Model model, @PathVariable Long id){

        model.addAttribute("list",os.findByOrderId(id));

        return "/orderListDetail";

    }



    @GetMapping("/adminOrderList")
    public String adminOrderList(Model model){
        model.addAttribute("list", os.findAll());
        return "/admin/adminOrdersList";
    }


}
