package com.example.FP.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RecipeController {

    @GetMapping("/addRecipe")
    public String addRecipe(){
        return "/addRecipe";
    }

    @GetMapping("/detailRecipe")

    public String detailRecipe(){
        return "/detailRecipe";
    }
}
