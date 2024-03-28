package com.example.FP.entity;

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

    private String notice_content;
    private String notice_title;
    private LocalDateTime notice_submit_date;

    public Notice(String notice_content, String notice_title, LocalDateTime notice_submit_date) {
        this.notice_content = notice_content;
        this.notice_title = notice_title;
        this.notice_submit_date = notice_submit_date;
    }
}
