package com.example.FP.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WishListController {

    @GetMapping("/wishList")
    public String wishListForm(){

        return "shop";
    }
}
