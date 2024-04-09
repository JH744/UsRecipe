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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class Event {

    @Id@GeneratedValue
    @Column(name = "event_id")
    private Long id;

    private String eventTitle;
    private String eventContent;
    private String eventThumbnail;
    private LocalDateTime eventSubmitDate;
    private LocalDateTime eventStartDate;
    private LocalDateTime eventEndDate;

    public Event(String eventTitle, String eventContent, String eventThumbnail, LocalDateTime eventSubmitDate, LocalDateTime eventStartDate, LocalDateTime eventEndDate) {
        this.eventTitle = eventTitle;
        this.eventContent = eventContent;
        this.eventThumbnail = eventThumbnail;
        this.eventSubmitDate = eventSubmitDate;
        this.eventStartDate = eventStartDate;
        this.eventEndDate = eventEndDate;
    }
}
