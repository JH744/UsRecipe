package com.example.FP.repository;

import com.example.FP.dto.InquiryDto;
import com.example.FP.entity.Inquiry;

import java.util.List;

public interface InquiryRepositoryCustom {

    List<Inquiry> listByUserid(String userid);

    List<Inquiry> listInquiryAnswerYet();

    List<Inquiry> listInquiryAnswered();

    void updateInquiry(Long id);


}
