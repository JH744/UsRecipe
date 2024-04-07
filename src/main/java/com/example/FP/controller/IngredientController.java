package com.example.FP.controller;

import com.example.FP.entity.Ingredient;
import com.example.FP.service.IngredientService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class IngredientController {

    private final IngredientService is;




    // 모든 재료목록
    @GetMapping("/listIngredient/{page}")
    public String listAll(@PathVariable("page") int page, Model model) {

        Pageable pageable =PageRequest.of(page-1, 6);


         Page<Ingredient>  list = is.listAll(pageable);
         int totalPage = list.getTotalPages();

        model.addAttribute("list", list);
        model.addAttribute("totalPage", totalPage);

        return "listIngredient" ;
    }




    //재료목록 : 카테고리별로 조회
    @GetMapping("/listIngredient/category/{categoryId}/page/{page}")
    public String IngredientList(Model model,
                                 @PathVariable(required = false) Long categoryId,
                                 @PathVariable("page") int page){

        Pageable pageable =PageRequest.of(page, 6);

        Page<Ingredient>  list = is.listByCategory(categoryId,pageable);
        int totalPage = list.getTotalPages();

        model.addAttribute("list", list);
        model.addAttribute("totalPage", totalPage);

        return "listIngredient" ;
    }





    @GetMapping("/ingredientDetail")
    public void ingredientDetail(){

    }








}
