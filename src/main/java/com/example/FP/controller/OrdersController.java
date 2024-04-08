package com.example.FP.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrdersController {


    @GetMapping("/order")
    public String orderPage(){

        return "orderPage";
    }
    @GetMapping("/orderOK")
    public String orderOK(){

        return "orderOK";
    }






}
