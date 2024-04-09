package com.example.FP.controller;

import com.example.FP.service.OrdersService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class OrdersController {
    private final OrdersService os;


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


        return "/orderList";

    }






}
