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

    public Alarm(int alarmState, String alarmMsg, Member alarmMember, Recipe alarmRecipe) {

        this.alarmState = alarmState;
        this.alarmMsg = alarmMsg;
        this.alarmMember = alarmMember;
        this.alarmRecipe = alarmRecipe;

    }
}
