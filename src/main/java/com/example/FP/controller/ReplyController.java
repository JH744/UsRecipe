package com.example.FP.controller;

import com.example.FP.service.ReplyService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class ReplyController {
    private final ReplyService rs;

    @PostMapping("/insertReply")
    @ResponseBody
    public void insertReply(@RequestParam(name = "gradeStar") int gradeStar,
                            @RequestParam(name = "replyContent") String replyContent,
                            @RequestParam(name = "recipeId") Long recipeId,
                            @RequestParam(name = "ingredientId") Long ingredientId,HttpSession session) {
        String userid = (String) session.getAttribute("userid");
        if(ingredientId==0){
            ingredientId=null;
        }
        if(recipeId==0){
            recipeId=null;
        }
        rs.insertReply(gradeStar, replyContent, recipeId, userid,ingredientId);
    }

    @PostMapping("/deleteReply")
    @ResponseBody
    public void deleteReply(@RequestParam(name="replyId") Long replyId){
        rs.deleteReply(replyId);
    }
}
