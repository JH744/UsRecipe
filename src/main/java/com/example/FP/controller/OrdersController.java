package com.example.FP.controller;

import com.example.FP.service.MemberService;
import com.example.FP.service.OrdersService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class OrdersController {
    private final OrdersService os;
    private final MemberService ms;


    @GetMapping("/order")
    public String orderPage(){

        return "orderPage";
    }
    @GetMapping("/orderOK")
    public String orderOK(){

        return "orderOK";
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






}
