package com.example.FP.mapper;

import com.example.FP.dto.InquiryDto;
import com.example.FP.dto.NoticeDto;
import com.example.FP.entity.Inquiry;
import com.example.FP.entity.Notice;
import org.springframework.stereotype.Component;

@Component
public class NoticeMapper {
    public static Notice toEntity(NoticeDto noticeDto){

        Notice notice = new Notice(noticeDto.getNotice_content(), noticeDto.getNotice_title(), noticeDto.getNotice_submit_date());
        return notice;
    }

}
