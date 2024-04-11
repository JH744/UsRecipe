package com.example.FP.repository;

import com.example.FP.entity.Inquiry;

import java.util.List;

public interface InquiryRepositoryCustom {

    List<Inquiry> listByUserid(String userid);
}
