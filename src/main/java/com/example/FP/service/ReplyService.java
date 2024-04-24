package com.example.FP.service;

import com.example.FP.dto.ReplyDto;
import com.example.FP.entity.Ingredient;
import com.example.FP.entity.Member;
import com.example.FP.entity.Recipe;
import com.example.FP.entity.Reply;
import com.example.FP.mapper.ReplyMapper;
import com.example.FP.repository.IngredientRepository;
import com.example.FP.repository.MemberRepository;
import com.example.FP.repository.RecipeRepository;
import com.example.FP.repository.ReplyRepository;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReplyService {
    private final ReplyRepository rr;
    private final MemberRepository mr;
    private final RecipeRepository recipeRepository;
    private final IngredientRepository ir;

    public void insertReply(int gradeStar, String replyContent, Long recipeId, String userid, Long ingredientId){
        Member member = mr.findByUserid(userid);
        Recipe recipe = null;

        Ingredient ingredient = null;
        if(ingredientId!=null){
            ingredient = ir.findById(ingredientId).get();
        }
        if(recipeId!=null){
            recipe = recipeRepository.findById(recipeId).get();
        }

        Long reply_id = rr.nextReplyId();
        ReplyDto replyDto = new ReplyDto(replyContent,LocalDateTime.now(),gradeStar,ingredient,recipe,member);
        Reply reply = ReplyMapper.toEntity(replyDto);

        rr.save(reply);
    }

    public void deleteReply(Long replyId){
        rr.deleteById(replyId);
    }

    public List<Reply> findAllByIngredientReply(Long ingredientId){
        return rr.findAllByIngredientReply(ingredientId);
    }

    @Transactional
    public void deleteAllByIngredientId(Long ingredient_id){
        rr.deleteAllByIngredientId(ingredient_id);
    }
}
