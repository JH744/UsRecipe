package com.example.FP.details;

import com.example.FP.entity.Member;
import jakarta.servlet.http.HttpSession;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

@Data
public class PrincipalDetails implements UserDetails, OAuth2User {

    private Member member;
    private Map<String, Object> attributes;

    //일반 로그인 생성자
    public PrincipalDetails(Member member) {
        System.out.println("일반 로그인 생성자");
        this.member = member;
    }

    //OAuth 로그인 생성자
    public PrincipalDetails(Member member, Map<String, Object> attributes ) {
        System.out.println("OAuth 로그인 생성자");
        this.member = member;
        this.attributes = attributes;
    }

    @Override
    public Map<String, Object> getAttributes() {
        return attributes;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collection = new ArrayList<>();
        collection.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {

                return String.valueOf(member.getRole());
            }
        });
        return collection;
    }

    @Override
    public String getPassword() {
        return member.getPassword();
    }

    @Override
    public String getUsername() {
        return member.getUserid();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // 계정 만료 여부를 항상 false가 아닌 true로 설정
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // 계정 잠금 여부를 항상 false가 아닌 true로 설정
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // 자격 증명 만료 여부를 항상 false가 아닌 true로 설정
    }

    @Override
    public boolean isEnabled() {
        return true; // 사용자 활성화 여부를 항상 false가 아닌 true로 설정
    }

    @Override
    public String getName() {
        return member.getName();
    }
}
