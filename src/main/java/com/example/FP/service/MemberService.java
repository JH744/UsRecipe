package com.example.FP.service;

import com.example.FP.dto.MemberDto;
import com.example.FP.entity.Member;
import com.example.FP.mapper.MemberMapper;
import com.example.FP.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {
    private final MemberRepository mr;

    public void validateDuplicateMember(Member member) {
        Member findMember = mr.findByUserid(member.getUserid());
        if (findMember != null) {
            throw new IllegalStateException("이미 가입된 회원입니다.");
        }
    }

    public Long join(Member member){
        System.out.println("맴버 서비스");
        validateDuplicateMember(member);
        mr.save(member);
        return member.getId();
    }

}
