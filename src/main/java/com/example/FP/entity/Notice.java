package com.example.FP.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
public class Notice {

    @Id@GeneratedValue
    @Column(name = "notice_id")
    private Long id;

    private String noticeContent;
    private String noticeTitle;
    private LocalDateTime noticeSubmitDate;

    public Notice(String noticeContent, String noticeTitle, LocalDateTime noticeSubmitDate) {
        this.noticeContent = noticeContent;
        this.noticeTitle = noticeTitle;
        this.noticeSubmitDate = noticeSubmitDate;
    }
}
