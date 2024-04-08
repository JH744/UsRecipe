package com.example.FP.controller;

import com.example.FP.service.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
@RequiredArgsConstructor
public class RecipeController {

    private final RecipeService rs;

    @GetMapping("/recipe")
    public String recipeList(Model model){

        //레시피목록 불러오기
        model.addAttribute("list",rs.list());

        //이 레시피는 어때요?
        long HowAboutToday ;
        //위 번호는 난수로 설정 (범위는 총 레시피수)
        //model.addAttribute("HowAbout",rs.HowAbout(sd));


        //주간인기레시피
        // 찜목록 중에서 레시피id를 count했을 시 가장 많은 top4를 불러옴

        return "recipe";
    }


    @GetMapping("/addRecipe")
    public String addRecipe(){
        return "/addRecipe";
    }

    @GetMapping("/detailRecipe")

    public String detailRecipe(){
        return "/detailRecipe";
    }








}
