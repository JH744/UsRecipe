package com.example.FP.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Notice {

    @Id@GeneratedValue
    @Column(name = "notice_id")
    private Long id;

    private String notice_content;
    private String notice_title;
    private LocalDateTime notice_submit_date;
}
