package com.example.FP.service;

import com.example.FP.entity.Notice;
import com.example.FP.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NoticeService {

    private final NoticeRepository nr;

    public List<Notice> findAll() { return nr.findAll(); }

    public Optional<Notice> findById(Long id) { return nr.findById(id); }

    public void save(Notice n) { nr.save(n); }

    public void deleteNotice(Long id) { nr.deleteById(id); }
}
