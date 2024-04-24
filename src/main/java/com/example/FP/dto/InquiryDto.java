package com.example.FP.dto;

import com.example.FP.entity.InquiryState;
import com.example.FP.entity.Member;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter@Setter
public class InquiryDto {
    private Long id;

    private String inquiry_title;
    private String inquiry_content;
    private String inquiry_answer;
    private String inquiry_category;
    private LocalDateTime inquiry_date;
    private LocalDateTime inquiry_answer_date;
    private InquiryState inquiry_state;


    private Member inquiry_member;


}
