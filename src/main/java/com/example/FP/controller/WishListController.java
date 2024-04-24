package com.example.FP.controller;

import com.example.FP.entity.Cart;
import com.example.FP.entity.WishList;
import com.example.FP.service.WishListService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class WishListController {

    private final WishListService ws;


    //찜 목록을 출력해오기 위한 메소드
    @GetMapping("/wishList")
    public String wishListForm(HttpSession session, Model model){
        model.addAttribute("list",ws.findAllWishList((String)session.getAttribute("userid")));

        return "/user/wishList";
    }

    //찜 목록 삭제를 위한 메소드
    @GetMapping("/deleteWishlist/{id}")
    public String deleteWishlist(@PathVariable Long id){
        ws.deleteWishlist(id);

        return "redirect:/wishList";
    }


    @PostMapping("/addWish")
    @ResponseBody
    public String addWish(Model model, @RequestParam ("Id") Long Id,HttpSession session){
        // 찜목록에 이미 있는 지 조회
        List<WishList> result =  ws.findById(Id,session);

        String coment= "";
        // result가 비어있다면 위시리스트에 새로 저장함.
        if(result.isEmpty()){
            ws.addWish(Id,session);
            coment = "저장함";
        }else{
            ws.deleteWish(Id,session);
            coment ="삭제함";
        }
        return coment;
    }



    @PostMapping("/checkWish")
    @ResponseBody
    public String checkWish(@RequestParam("Id") long Id, HttpSession session){

        List<WishList> result =  ws.findById(Id,session);
        String coment= "";
        if(result.isEmpty()){
            coment = "저장안됨";
        }else{
            coment ="저장됨";
        }
        return coment;
    }


}
