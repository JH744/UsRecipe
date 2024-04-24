package com.example.FP.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Inquiry {
    @Id@GeneratedValue
    @Column(name = "inquiry_id")
    private Long id;

    private String inquiryTitle;
    private String inquiryContent;
    private String inquiryAnswer;
    private String inquiryCategory;
    private LocalDateTime inquiryDate;
    private LocalDateTime inquiryAnswerDate;
    @Enumerated(EnumType.STRING)
    private InquiryState inquiryState;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member inquiryMember;


    public Inquiry(String inquiryTitle, String inquiryContent, String inquiryAnswer, String inquiryCategory,LocalDateTime inquiryDate, LocalDateTime inquiryAnswerDate, InquiryState inquiryState, Member inquiryMember) {
        this.inquiryTitle = inquiryTitle;
        this.inquiryContent = inquiryContent;
        this.inquiryAnswer = inquiryAnswer;
        this.inquiryCategory=inquiryCategory;
        this.inquiryDate = inquiryDate;
        this.inquiryAnswerDate = inquiryAnswerDate;
        this.inquiryState = inquiryState;
        this.inquiryMember = inquiryMember;
    }

    public Inquiry insertInquiry(Inquiry inquiry, Member member){

        Inquiry inquiry1 = new Inquiry(inquiry.inquiryTitle,inquiry.inquiryContent,inquiry.inquiryAnswer,inquiry.inquiryCategory, LocalDateTime.now(),inquiry.inquiryAnswerDate,InquiryState.NO,member);

        return inquiry1;

    }

}
