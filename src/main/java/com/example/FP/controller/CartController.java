package com.example.FP.controller;

import com.example.FP.entity.Cart;
import com.example.FP.service.CartService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class CartController {


    private final CartService cs;

    @GetMapping("/cart")
    public String cartList(Model model){

        //model.addAttribute("list",cs.listCart());
        return "cart";
    }

@PostMapping("/insertCart")
@ResponseBody
    public String insertCart(@RequestParam(name = "ingredientId") Long ingredientId, HttpSession session){
        String userid = session.getAttribute("userid").toString();
        cs.insertCart(userid,ingredientId);
        return "/";
}







}

