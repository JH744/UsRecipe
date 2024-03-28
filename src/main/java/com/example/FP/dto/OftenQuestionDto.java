package com.example.FP.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class OftenQuestionDto {

    private Long id;

    private String often_question_title;
    private String often_question_answer;
}
