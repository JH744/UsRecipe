package com.example.FP.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class Reply {
    @Id@GeneratedValue
    @Column(name = "reply_id")
    private Long id;

    private String replyContent;
    private LocalDateTime replyDate;
    private int replyGrade;

    @ManyToOne
    @JoinColumn(name = "ingredient_id")
    private Ingredient replyIngredient;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe replyRecipe;

    @ManyToOne
    @JoinColumn(name ="member_id")
    private Member replyMember;

    public Reply(String replyContent, LocalDateTime replyDate, int replyGrade, Ingredient replyIngredient, Recipe replyRecipe, Member replyMember) {
        this.replyContent = replyContent;
        this.replyDate = replyDate;
        this.replyGrade = replyGrade;
        this.replyIngredient = replyIngredient;
        this.replyRecipe = replyRecipe;
        this.replyMember = replyMember;

    }
}
