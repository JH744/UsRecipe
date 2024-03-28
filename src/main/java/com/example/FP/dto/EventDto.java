package com.example.FP.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class EventDto {

    private Long id;

    private String event_title;
    private String event_content;
    private String event_thumbnail;
    private LocalDateTime event_submit_date;
    private LocalDateTime event_start_date;
    private LocalDateTime event_end_date;
}
