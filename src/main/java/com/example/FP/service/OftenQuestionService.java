package com.example.FP.service;

import com.example.FP.repository.OftenQuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OftenQuestionService {

    private final OftenQuestionRepository oqr;
}
