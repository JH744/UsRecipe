package com.example.FP.mapper;

import com.example.FP.dto.EventDto;
import com.example.FP.dto.MemberDto;
import com.example.FP.entity.Event;
import com.example.FP.entity.Member;
import org.springframework.stereotype.Component;

@Component
public class EventMapper {

    public static Event toEntity(EventDto eventDto){
        Event event = new Event(eventDto.getEvent_title(), eventDto.getEvent_content(), eventDto.getEvent_thumbnail(), eventDto.getEvent_submit_date(),eventDto.getEvent_start_date(),eventDto.getEvent_end_date());

        return event;
    }
}
