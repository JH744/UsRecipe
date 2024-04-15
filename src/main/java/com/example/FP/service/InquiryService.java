package com.example.FP.service;

import com.example.FP.entity.Inquiry;
import com.example.FP.repository.InquiryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InquiryService {

    private final InquiryRepository ir;

    public List<Inquiry> findAll(){
        return ir.findAll();
    }

    public void save(Inquiry inquiry){
        ir.save(inquiry);
    }

    public void delete(Long inquiry_id){
        ir.deleteById(inquiry_id);
    }
}
