package com.example.FP.dto;

import com.example.FP.entity.Member;
import com.example.FP.entity.Recipe;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class AlarmDto {
    private Long id;
    private int alarm_state;
    private String alarm_msg;
    private Member alarm_member;
    private Recipe alarm_recipe;

}
