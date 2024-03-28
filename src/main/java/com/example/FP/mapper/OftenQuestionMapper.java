package com.example.FP.mapper;

import com.example.FP.dto.NoticeDto;
import com.example.FP.dto.OftenQuestionDto;
import com.example.FP.entity.Notice;
import com.example.FP.entity.OftenQuestion;
import org.springframework.stereotype.Component;

@Component
public class OftenQuestionMapper {
    public static OftenQuestion toEntity(OftenQuestionDto oftenQuestionDto){
        OftenQuestion oftenQuestion = new OftenQuestion(oftenQuestionDto.getOften_question_title(), oftenQuestionDto.getOften_question_answer());
        return oftenQuestion;


    }


}
