package com.example.FP.entity;

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

    private String often_question_title;
    private String often_question_answer;

    public OftenQuestion(String often_question_title, String often_question_answer) {
        this.often_question_title = often_question_title;
        this.often_question_answer = often_question_answer;
    }
}
