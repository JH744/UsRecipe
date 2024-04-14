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

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CartController {


    private final CartService cs;



    @GetMapping("/cart")
    public String cartList(Model model){
        //로그인한 회원의 id로 저장된 장바구니 목록을 가져옴
        long memberId = 52; //임시 id 부여
        //long memberId = 102;  // 빈 장바구니 확인용


         var list = cs.listCart(memberId);



        model.addAttribute("list",list);

        return "cart";
    }




    @PostMapping("/checkCart")
    @ResponseBody
    public String checkCart(@RequestParam("Id") long Id){
        System.out.println("확인할 id :"+Id);
        long memberId = 52; //임시 회원id

        List<Cart> result =  cs.findById(Id,memberId);
        String coment= "";
        if(result.isEmpty()){
            coment = "저장안됨";
        }else{
            coment ="저장됨";
        }
        System.out.println(coment);
        return coment;

    }



    @PostMapping("/addCart")
    @ResponseBody
    public String addCart(Model model, @RequestParam ("Id") Long Id ){
        System.out.println("전달받은거:"+Id);
        long memberId = 52; //임시 회원id

           List<Cart> result =  cs.findById(Id,memberId);

            String coment= "";
        if(result.isEmpty()){
            cs.addCart(Id,memberId);
            coment = "저장함";
        }else{
            coment ="저장안함";
        }
        System.out.println(coment);
        return coment;
    }









}

