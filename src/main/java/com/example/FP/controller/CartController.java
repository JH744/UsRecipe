package com.example.FP.controller;

import com.example.FP.entity.Cart;
import com.example.FP.service.CartService;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class CartController {


    private final CartService cs;

    @GetMapping("/cart")
    public void cartList(){

    }









}

