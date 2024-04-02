package com.example.FP.service;

import com.example.FP.entity.Member;
import com.example.FP.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberSecurityService implements UserDetailsService {

    private final MemberRepository mr;

    @Override
    public UserDetails loadUserByUsername(String userid) throws UsernameNotFoundException {

        Member m = mr.findByUserid(userid);
        if (m == null) {
            throw new UsernameNotFoundException(userid);
        }

        UserDetails details = null;
        UserBuilder builder = User.builder();
        builder.username(m.getUserid());
        builder.password(m.getPassword());
        builder.roles(String.valueOf(m.getRole()));
        details = builder.build();

        System.out.println("빌버 실행함");
        return details;
    }
}
