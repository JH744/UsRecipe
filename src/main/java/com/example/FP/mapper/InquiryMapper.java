package com.example.FP.mapper;

import com.example.FP.dto.InquiryDto;
import com.example.FP.dto.MemberDto;
import com.example.FP.entity.Inquiry;
import com.example.FP.entity.Member;
import org.springframework.stereotype.Component;

@Component
public class InquiryMapper {

    public static Inquiry toEntity(InquiryDto inquiryDto){
        Inquiry inquiry = new Inquiry(inquiryDto.getInquiry_title(), inquiryDto.getInquiry_content(), inquiryDto.getInquiry_answer(), inquiryDto.getInquiry_date(),inquiryDto.getInquiry_answer_date(),inquiryDto.getInquiry_state(),inquiryDto.getInquiry_member());
        return inquiry;

    }
}
