package com.example.FP.service;

import com.example.FP.entity.Event;
import com.example.FP.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EventService {
    private final EventRepository er;

    public List<Event> findAll(){ return er.findAll(); }

    public Optional<Event> findById(Long id) {return er.findById(id); }

    public void save(Event e) { er.save(e); }

    public void deleteEvent(Long id){ er.deleteById(id); }
}
