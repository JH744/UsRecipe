package com.example.FP.controller;

import com.example.FP.entity.Ingredient;
import com.example.FP.service.IngredientService;
import com.google.gson.Gson;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class IngredientController {

    private final IngredientService is;


    // 재료 목록 불러오기 -페이지는 경로변수로 받고, 나머지는 쿼리스트링으로 받음
    @GetMapping("/listIngredient/{page}")
    public String listAll(@PathVariable("page") int page, Model model,
                          @RequestParam(required = false ) Long category,
                          @RequestParam(required = false ) String sortBy,
                          @RequestParam(required = false ) String direction,
                          HttpSession session){


        // **정렬 및 카테고리 상태유지** //
        //category에 null이 아닌 새값이 전달된 경우 세션에 새롭게 저장.
        if(category != null) {
            session.setAttribute("category", category);
        }else {
            //category가 null이라면 기존session에서 값을 가져옴
            category= (Long) session.getAttribute("category");
        }


        //sort에 null이 아닌 새값이 전달된 경우 세션에 새롭게 저장.
        if(sortBy != null) {
            session.setAttribute("sort", sortBy);
            System.out.println("sortBy저장됨");
            System.out.println(session.getAttribute("sort"));
            session.setAttribute("direction", direction);
            System.out.println("direction저장됨");
            System.out.println(session.getAttribute("direction"));
        }else {
            //sort가 null이면 기존session에서 값을 가져옴
            sortBy = (String) session.getAttribute("sort");
            direction = (String) session.getAttribute("direction");
        }


        //***정렬조건 유무 >>  로직 설정***//
        Pageable pageable;
        if (sortBy != null && !sortBy.isEmpty()) {  //정렬조건이 넘어 올 경우
            Sort.Direction Direction = (direction.equals("ASC") ? Sort.Direction.ASC : Sort.Direction.DESC );
            pageable = PageRequest.of(page-1, 6, Direction, sortBy);
            System.out.println("소트 뽑아봄");
            System.out.println(sortBy);
            System.out.println(pageable.getSort());
        } else {  // 정렬 방향이 지정되지 않았을 경우 기본값 사용
            pageable = PageRequest.of(page-1, 6);
        }



        //**** 카테고리 적용 ****//

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





    @GetMapping("/ingredientDetail")
    public void ingredientDetail(){

    }

    @PostMapping("/searchIngredient")
    @ResponseBody
    public List<Ingredient> searchIngredient(@RequestParam("keyword") String keyword){
        List<Ingredient> list = is.findAllByIngredientNameContaining(keyword);
        for (Ingredient i : list){
            System.out.println("재료명 : "+i.getIngredientName());
        }
        return list;
    }


}
