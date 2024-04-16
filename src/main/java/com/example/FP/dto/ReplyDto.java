package com.example.FP.dto;

import com.example.FP.entity.Ingredient;
import com.example.FP.entity.Member;
import com.example.FP.entity.Recipe;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter@Setter
@NoArgsConstructor
public class ReplyDto {

    private Long id;

    private String reply_content;
    private LocalDateTime reply_date;
    private int reply_grade;


    private Ingredient reply_ingredient;


    private Recipe reply_recipe;


    private Member reply_member;

    public ReplyDto(String reply_content, LocalDateTime reply_date, int reply_grade, Ingredient reply_ingredient, Recipe reply_recipe, Member reply_member) {
        this.reply_content = reply_content;
        this.reply_date = reply_date;
        this.reply_grade = reply_grade;
        this.reply_ingredient = reply_ingredient;
        this.reply_recipe = reply_recipe;
        this.reply_member = reply_member;
    }
}
