package com.example.FP.controller;

import com.example.FP.dto.EventDto;
import com.example.FP.mapper.EventMapper;
import com.example.FP.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class EventController {

    private final EventService es;
    @GetMapping("/eventList")
    public String eventList(Model model){
        model.addAttribute("list", es.findAll());
        return "/event";
    }

    @GetMapping("/eventInsert")
    public String eventForm(){
        return "/eventInsert";
    }

    @PostMapping("/eventInsert")
    public String eventSubmit(EventDto eventDto){
        es.save(EventMapper.toEntity(eventDto));
        return "redirect:/eventList";
    }

    @GetMapping("/eventDetail/{id}")
    public String eventDetail(@PathVariable Long id, Model model) {
        model.addAttribute("list", es.findById(id));
        return "/eventDetail";
    }

    @GetMapping("/eventUpdate/{id}")
    public String eventUpdateForm(@PathVariable Long id, Model model){
        model.addAttribute(es.findById(id));
        return "/eventUpdate";
    }

    @PostMapping("/eventUpdate")
    public String eventUpdateSubmit(EventDto eventDto){
        es.save(EventMapper.toEntity(eventDto));
        return "redirect:/eventList";
    }

    @GetMapping("/eventDelete/{id}")
    public void eventDelete(@PathVariable Long id, Model model) {
        es.deleteEvent(id);
    }
}
