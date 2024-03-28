package com.example.FP.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter@Setter
public class NoticeDto {

    private Long id;

    private String notice_content;
    private String notice_title;
    private LocalDateTime notice_submit_date;
}
