package com.example.FP.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class OftenQuestion {

    @Id@GeneratedValue
    @Column(name = "often_question_id")
    private Long id;

    private String oftenQuestionTitle;
    private String oftenQuestionAnswer;

    public OftenQuestion(String oftenQuestionTitle, String oftenQuestionAnswer) {
        this.oftenQuestionTitle = oftenQuestionTitle;
        this.oftenQuestionAnswer = oftenQuestionAnswer;
    }
}
