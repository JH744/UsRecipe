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
public class Inquiry {
    @Id@GeneratedValue
    @Column(name = "inquiry_id")
    private Long id;

    private String inquiry_title;
    private String inquiry_content;
    private String inquiry_answer;
    private String inquiry_category;
    private LocalDateTime inquiry_date;
    private LocalDateTime inquiry_answer_date;
    @Enumerated(EnumType.STRING)
    private InquiryState inquiry_state;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member inquiryMember;

    public Inquiry(String inquiry_title, String inquiry_content, String inquiry_answer, String inquiry_category,LocalDateTime inquiry_date, LocalDateTime inquiry_answer_date, InquiryState inquiry_state, Member inquiry_member) {
        this.inquiry_title = inquiry_title;
        this.inquiry_content = inquiry_content;
        this.inquiry_answer = inquiry_answer;
        this.inquiry_category=inquiry_category;
        this.inquiry_date = inquiry_date;
        this.inquiry_answer_date = inquiry_answer_date;
        this.inquiry_state = inquiry_state;
        this.inquiryMember = inquiry_member;
    }
}
