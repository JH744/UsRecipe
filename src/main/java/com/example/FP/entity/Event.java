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
public class Event {

    @Id@GeneratedValue
    @Column(name = "event_id")
    private Long id;

    private String event_title;
    private String event_content;
    private String event_thumbnail;
    private LocalDateTime event_submit_date;
    private LocalDateTime event_start_date;
    private LocalDateTime event_end_date;

    public Event(String event_title, String event_content, String event_thumbnail, LocalDateTime event_submit_date, LocalDateTime event_start_date, LocalDateTime event_end_date) {
        this.event_title = event_title;
        this.event_content = event_content;
        this.event_thumbnail = event_thumbnail;
        this.event_submit_date = event_submit_date;
        this.event_start_date = event_start_date;
        this.event_end_date = event_end_date;
    }
}
