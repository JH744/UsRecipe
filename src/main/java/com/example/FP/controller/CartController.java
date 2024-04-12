package com.example.FP.controller;

import com.example.FP.entity.Cart;
import com.example.FP.entity.Ingredient;
import com.example.FP.service.CartService;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class CartController {


    private final CartService cs;






    @GetMapping("/cart")
    public String cartList(Model model){
        //로그인한 회원의 id로 저장된 장바구니 목록을 가져옴
        long memberId = 52; //임시 id 부여

         var list = cs.listCart(memberId);



        model.addAttribute("list",list);

        return "cart";
    }







    @PostMapping("/addCart")
    @ResponseBody
    public String addCart(Model model, @RequestParam ("Id") Long Id ){
        System.out.println("전달받은거:"+Id);

        //로그인된 유저 id 정보를 memberId에 저장
        long memberId = 52;

     ;   cs.addCart(Id,memberId);


        return "장바구니추가함";
    }









}

