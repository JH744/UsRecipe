package com.example.FP.service;

import com.example.FP.repository.OrderStateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderStateService {

    private final OrderStateRepository osr;
}
