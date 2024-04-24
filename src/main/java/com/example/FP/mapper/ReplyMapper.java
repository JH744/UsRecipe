package com.example.FP.mapper;

import com.example.FP.dto.NoticeDto;
import com.example.FP.dto.ReplyDto;
import com.example.FP.entity.Notice;
import com.example.FP.entity.Reply;
import org.springframework.stereotype.Component;

@Component
public class ReplyMapper {
    public static Reply toEntity(ReplyDto replyDto){
        Reply reply = new Reply(replyDto.getReply_content(),replyDto.getReply_date(),replyDto.getReply_grade(),replyDto.getReply_ingredient(),replyDto.getReply_recipe(),replyDto.getReply_member());
        return reply;
    }
}
