package com.example.FP.mapper;

import com.example.FP.dto.InquiryDto;
import com.example.FP.entity.Inquiry;
import com.example.FP.entity.InquiryState;
import com.example.FP.entity.Member;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class InquiryMapper {

    public static Inquiry toEntity(InquiryDto inquiryDto) {
        if (inquiryDto == null) {
            return null;
        }
        return Inquiry.builder()
                .inquiryTitle(inquiryDto.getInquiry_title())
                .inquiryContent(inquiryDto.getInquiry_content())
                .inquiryCategory(inquiryDto.getInquiry_category())
                .inquiryDate(LocalDateTime.now()) // 문의 등록 시각을 현재 시각으로 설정
                .inquiryState(InquiryState.NO) // 초기 상태를 '노'으로 설정
                .build();
    }
}
