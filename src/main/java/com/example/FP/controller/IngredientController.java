package com.example.FP.controller;

import com.example.FP.service.IngredientService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class IngredientController {

    private final IngredientService is;

    @GetMapping("/listIngredient")
    public String IngredientList(Model model){
        model.addAttribute("list", is.list());
        return "listIngredient" ;
    }


    @GetMapping("/ingredientDetail")
    public void ingredientDetail(){

    }








}
