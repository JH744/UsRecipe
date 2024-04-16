package com.example.FP.service;

import com.example.FP.dto.ReplyDto;
import com.example.FP.entity.Member;
import com.example.FP.entity.Recipe;
import com.example.FP.entity.Reply;
import com.example.FP.mapper.ReplyMapper;
import com.example.FP.repository.MemberRepository;
import com.example.FP.repository.RecipeRepository;
import com.example.FP.repository.ReplyRepository;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class ReplyService {
    private final ReplyRepository rr;
    private final MemberRepository mr;
    private final RecipeRepository recipeRepository;

    public void insertReply(int gradeStar, String replyContent, Long recipeId, String userid){
        Member member = mr.findByUserid(userid);
        Recipe recipe = recipeRepository.findById(recipeId).get();
        Long reply_id = rr.nextReplyId();
        ReplyDto replyDto = new ReplyDto(replyContent,LocalDateTime.now(),gradeStar,null,recipe,member);
        Reply reply = ReplyMapper.toEntity(replyDto);

        rr.save(reply);
    }

    public void deleteReply(Long replyId){
        rr.deleteById(replyId);
    }
}
