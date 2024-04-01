package com.example.FP.service;

import com.example.FP.dto.MemberDto;
import com.example.FP.entity.Member;
import com.example.FP.mapper.MemberMapper;
import com.example.FP.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository mr;

    public Long join(MemberDto memberDto){
        Member member = mr.save(MemberMapper.toEntity(memberDto));
        return member.getId();

    }
}
