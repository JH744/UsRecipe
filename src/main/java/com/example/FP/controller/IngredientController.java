package com.example.FP.controller;

import com.example.FP.entity.Ingredient;
import com.example.FP.service.IngredientService;
import com.example.FP.service.RecipeIngredientService;
import com.example.FP.service.ReplyService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Parameters;
import org.springframework.stereotype.Controller;
import com.fasterxml.jackson.core.type.TypeReference;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.util.List;

import java.util.ArrayList;

@Controller
@RequiredArgsConstructor
public class IngredientController {

    private final IngredientService is;
    private final ReplyService rs;
    private final RecipeIngredientService ris;




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
            session.setAttribute("direction", direction);
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



        return "/all/listIngredient" ;
    }





    @GetMapping("/detailIngredient")
    public String detailIngredient(@RequestParam(name = "ingredientId") Long ingredientId, Model model){
        Ingredient ingredient = is.findById(ingredientId).get();
        model.addAttribute("ingredient",ingredient);
        model.addAttribute("reply",rs.findAllByIngredientReply(ingredientId));
        return "all/detailIngredient";
    }

    @PostMapping("/searchIngredient")
    @ResponseBody
    public List<Ingredient> searchIngredient(@RequestParam("keyword") String keyword){
        List<Ingredient> list = is.findAllByIngredientNameContaining(keyword);
        return list;
    }

//    장바구니에 추가하기 위해 여러개 검색하는 용도
    @PostMapping("/findIngredient")
    @ResponseBody
    public List<Ingredient> findIngredient(@RequestBody List<Long> checkList){
        List<Ingredient> list = new ArrayList<Ingredient>();

        for(Long id : checkList){
            list.add(is.findById(id).get());
        }

        return list;
    }

    @GetMapping("/deleteIngredient/{id}")
    public String deleteIngredient(@PathVariable Long id, HttpServletRequest request){
        Ingredient ingredient = is.findById(id).get();

        String fileRoot = request.getServletContext().getRealPath("/ingredientImages");	//저장될 외부 파일 경로
        String fname = ingredient.getIngredientImage();
        try{
            File file = new File(fileRoot+"/"+fname);
            file.delete();
        }catch (Exception e){
//            System.out.println(e.getMessage());
        }
        ris.updateIngredientId(id);
        rs.deleteAllByIngredientId(id);
        is.deleteIngredient(id);

        return "redirect:/admin/ingredient";
    }

    @GetMapping("/admin/updateIngredient/{id}")
    public String updateIngredient(@PathVariable("id") Long id, Model model) {
        model.addAttribute("list", is.findAllIngredientCategory());
        model.addAttribute("i", is.findById(id).get());
        return "/admin/adminUpdateIngredient";
    }


}
