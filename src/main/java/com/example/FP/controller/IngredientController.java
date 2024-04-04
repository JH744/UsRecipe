package com.example.FP.controller;

import com.example.FP.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IngredientController {


    @Autowired
    IngredientService is;

    @GetMapping("/store")
    public void IngredientList(Model model){
        model.addAttribute("list", is.list());
    }




}
