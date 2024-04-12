package com.example.FP.controller;

import com.example.FP.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class ReplyController {
    private final ReplyService rs;

    @PostMapping("/insertReply")
    public String insertReply(@RequestParam(name="gradeStar") int gradeStar,@RequestParam(name="replyContent") String replyContent,@RequestParam(name="recipeId") Long recipeId){
        rs.insertReply(gradeStar,replyContent,recipeId);
        return "redirect:/detailRecipe?recipeNum="+recipeId;
    }
}
