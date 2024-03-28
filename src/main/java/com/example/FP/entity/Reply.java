package com.example.FP.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Reply {
    @Id@GeneratedValue
    @Column(name = "reply_id")
    private Long id;

    private String reply_content;
    private LocalDateTime reply_date;
    private int reply_grade;

    @ManyToOne
    @JoinColumn(name = "ingredient_id")
    private Ingredient reply_ingredient;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe reply_recipe;

    @ManyToOne
    @JoinColumn(name ="member_id")
    private Member reply_member;

    public Reply(String reply_content, LocalDateTime reply_date, int reply_grade, Ingredient reply_ingredient, Recipe reply_recipe, Member reply_member) {
        this.reply_content = reply_content;
        this.reply_date = reply_date;
        this.reply_grade = reply_grade;
        this.reply_ingredient = reply_ingredient;
        this.reply_recipe = reply_recipe;
        this.reply_member = reply_member;
    }
}
