package com.example.FP.service;

import com.example.FP.dto.MemberDto;
import com.example.FP.entity.Member;
import com.example.FP.mapper.MemberMapper;
import com.example.FP.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Transactional
public class MemberService implements UserDetailsService {
    private final MemberRepository mr;

    public void validateDuplicateMember(Member member) {
        Member findMember = mr.findByUserid(member.getUserid());
        if (findMember != null) {
            throw new IllegalStateException("이미 가입된 회원입니다.");
        }
    }

    public Long join(Member member){
        validateDuplicateMember(member);
        System.out.println("맴버 서비스");
        mr.save(member);
        return member.getId();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member m = mr.findByUserid(username);
        if (m == null) {
            throw new UsernameNotFoundException(username);
        }
        UserDetails user = null;
        user = User.builder()
                .username(username)
                .password(m.getPassword())
                .roles(String.valueOf(m.getRole()))
                .build();
        return user;
    }

    public Long findById(String userid){
        Member byUserid = mr.findByUserid(userid);
        return byUserid.getId();
    }

    public Boolean findByUserid(String userid){
        Member byUserid = mr.findByUserid(userid);
        if (byUserid != null) {
            if (byUserid.getUserid() == null) {
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

    public Boolean findByEmail(String email){
        Member byEmail = mr.findByEmail(email);
        if (byEmail != null) {
            if (byEmail.getEmail() == null) {
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

    public Boolean findByNickname(String nickname){
        Member byNickname = mr.findByNickname(nickname);
        if (byNickname != null) {
            if (byNickname.getNickname() == null) {
                return false;
            } else {
                return true;
            }
        }
        return false;
    }
}
