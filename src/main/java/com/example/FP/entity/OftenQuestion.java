package com.example.FP.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class OftenQuestion {

    @Id@GeneratedValue
    @Column(name = "often_question_id")
    private Long id;

    private String often_question_title;
    private String often_question_answer;
}
