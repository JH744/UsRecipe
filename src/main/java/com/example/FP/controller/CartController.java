package com.example.FP.controller;

import com.example.FP.entity.Cart;
import com.example.FP.entity.Ingredient;
import com.example.FP.service.CartService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class CartController {


    private final CartService cs;


    @GetMapping("/cart")
    public String cartList(Model model, HttpSession session){
         var list = cs.listCart(session);
        model.addAttribute("list",list);
        return "cart";
    }




    @PostMapping("/checkCart")
    @ResponseBody
    public String checkCart(@RequestParam("Id") long Id,HttpSession session){
        System.out.println("확인할 id :"+Id);
        List<Cart> result =  cs.findById(Id,session);
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
    public String addCart(HttpSession session, Model model, @RequestParam ("Id") Long Id ){
        System.out.println("전달받은거:"+Id);

        List<Cart> result =  cs.findById(Id,session);

            String coment= "";
        if(result.isEmpty()){
            cs.addCart(Id,session);
            coment = "저장함";
        }else{
            coment ="저장안함";
        }
        System.out.println(coment);
        return coment;
    }


    @PostMapping("/deleteCartItems")
    @ResponseBody
    public String deleteCartItems(@RequestBody Map<String, List<String>> data, HttpSession session) {

        List<String> ingredientNames = data.get("ingredientNames");
        System.out.println("전달받은 상품명들 : "+ingredientNames);
            cs.deleteCart(ingredientNames,session);
             return "기달";
    }






}

