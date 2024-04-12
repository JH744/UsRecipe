package com.example.FP.service;

import com.example.FP.dto.ReplyDto;
import com.example.FP.repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReplyService {
    private final ReplyRepository rr;

    public void insertReply(int gradeStar,String replyContent,Long recipeId){
        System.out.println(gradeStar+"    "+replyContent+"    "+recipeId);
    }
}
