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
    private LocalDateTime inquiry_date;
    private LocalDateTime inquiry_answer_date;
    @Enumerated(EnumType.STRING)
    private InquiryState inquiry_state;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member inquiry_member;

}
