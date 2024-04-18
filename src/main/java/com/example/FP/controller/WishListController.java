package com.example.FP.controller;

import com.example.FP.service.WishListService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

        return "redirect:/user/wishList";
    }
}
