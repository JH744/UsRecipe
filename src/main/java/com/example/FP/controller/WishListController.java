package com.example.FP.controller;

import com.example.FP.entity.Cart;
import com.example.FP.entity.WishList;
import com.example.FP.service.WishListService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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


    @PostMapping("/addWish")
    @ResponseBody
    public String addWish(Model model, @RequestParam ("Id") Long Id){
        System.out.println("전달받은거:"+Id);
        long memberId = 52; //임시 회원id
        // 찜목록에 이미 있는 지 조회
        List<WishList> result =  ws.findById(Id,memberId);

        String coment= "";
        if(result.isEmpty()){
            ws.addWish(Id,memberId);
            coment = "저장함";
        }else{
            coment ="저장안함";
        }
        System.out.println(coment);
        return coment;
    }



    @PostMapping("/checkWish")
    @ResponseBody
    public String checkWish(@RequestParam("Id") long Id){
        System.out.println("확인할 id :"+Id);
        long memberId = 52; //임시 회원id

        List<WishList> result =  ws.findById(Id,memberId);
        String coment= "";
        if(result.isEmpty()){
            coment = "저장안됨";
        }else{
            coment ="저장됨";
        }
        System.out.println(coment);
        return coment;

    }


}
