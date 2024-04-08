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
    private int alarmState;
    private String alarmMsg;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member alarmMember;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe alarmRecipe;

    public Alarm(int alarm_state, String alarm_msg, Member alarm_member, Recipe alarm_recipe) {
        this.alarmState = alarm_state;
        this.alarmMsg = alarm_msg;
        this.alarmMember = alarm_member;
        this.alarmRecipe = alarm_recipe;
    }
}
