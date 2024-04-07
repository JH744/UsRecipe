package com.example.FP.controller;

import com.example.FP.entity.Ingredient;
import com.example.FP.service.IngredientService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class IngredientController {

    private final IngredientService is;




    // 모든 재료목록
    @GetMapping("/listIngredient/{page}")
    public String listAll(@PathVariable("page") int page, Model model,
                          @RequestParam(required = false ) Long category,
                          @RequestParam(required = false ) String sort,
                          HttpSession session){

        Pageable pageable =PageRequest.of(page-1, 6);

        //category에 null이 아닌 새값이 전달된 경우 세션에 새롭게 저장.
        if(category != null) {
            session.setAttribute("category", category);
        }else {
            //category가 null이라면 기존session에서 값을 가져옴
             category= (Long) session.getAttribute("category");
        }


        //sort에 null이 아닌 새값이 전달된 경우 세션에 새롭게 저장.
        if(sort != null) {
            session.setAttribute("sort", sort);
        }else {
            //sort가 null이면 기존session에서 값을 가져옴
           sort = (String) session.getAttribute("sort");
        }
        //카테고리가 전체보기(000)이라면 모든 목록 불러오기
        if(category == null || category == 000) {
            Page<Ingredient>  list = is.listAll(pageable);
            int totalPage = list.getTotalPages();
            model.addAttribute("list", list);
            model.addAttribute("totalPage", totalPage);
        }
        //카테고리가 전체보기(000)이 아니라면 카테고리 목록 불러오기
        else if(category != 000){
            Page<Ingredient>  list = is.listByCategory(category,pageable);
            int totalPage = list.getTotalPages();
            model.addAttribute("list", list);
            model.addAttribute("totalPage", totalPage);
        }



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
