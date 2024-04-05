package com.example.FP.controller;

import com.example.FP.service.WishListService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class WishListController {

    private final WishListService ws;

    @GetMapping("/wishList")
    public String wishListForm(HttpSession session, Model model){

        String userid = (String)session.getAttribute("userid");
        model.addAttribute("list",ws.findAllWishList(userid));

        return "/wishList";
    }
}
