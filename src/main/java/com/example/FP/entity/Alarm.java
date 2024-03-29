package com.example.FP.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Alarm {

    @Id@GeneratedValue
    @Column(name = "alarm_id")
    private Long id;
    private int alarm_state;
    private String alarm_msg;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member alarm_member;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe alarm_recipe;

    public Alarm(int alarm_state, String alarm_msg, Member alarm_member, Recipe alarm_recipe) {
        this.alarm_state = alarm_state;
        this.alarm_msg = alarm_msg;
        this.alarm_member = alarm_member;
        this.alarm_recipe = alarm_recipe;
    }
}
