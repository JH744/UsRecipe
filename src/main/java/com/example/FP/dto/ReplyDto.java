package com.example.FP.dto;

import com.example.FP.entity.Ingredient;
import com.example.FP.entity.Member;
import com.example.FP.entity.Recipe;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter@Setter
public class ReplyDto {

    private Long id;

    private String reply_content;
    private LocalDateTime reply_date;
    private int reply_grade;


    private Ingredient reply_ingredient;


    private Recipe reply_recipe;


    private Member reply_member;
}
