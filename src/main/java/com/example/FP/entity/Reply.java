package com.example.FP.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
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
}
