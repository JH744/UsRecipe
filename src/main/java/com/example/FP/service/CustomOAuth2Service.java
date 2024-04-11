package com.example.FP.service;

import com.example.FP.details.PrincipalDetails;
import com.example.FP.entity.Member;
import com.example.FP.entity.MemberRole;
import com.example.FP.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CustomOAuth2Service extends DefaultOAuth2UserService {

    private final MemberRepository memberRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        // OAuth 서비스(kakao, google, naver)에서 가져온 유저 정보를 담고있음
        OAuth2User oauth2user = super.loadUser(userRequest);

        String userNameAttributeName = userRequest.getClientRegistration()
                .getProviderDetails()
                .getUserInfoEndpoint()
                .getUserNameAttributeName(); // OAuth 로그인 시 키(pk)가 되는 값
        Map<String, Object> attributes = oauth2user.getAttributes(); // OAuth 서비스의 유저 정보들

        System.out.println(userNameAttributeName);
        HashMap<String, Object> account = (HashMap<String, Object>) attributes.get("kakao_account");
        HashMap<String, Object> profile = (HashMap<String, Object>) account.get("profile");
        String name = (String) profile.get("nickname");
        String email = (String) account.get("email");
        String nickname = "kakao_" + attributes.get("id");

        System.out.println("이름 " + name);
        System.out.println("이메일 " + email);
        System.out.println("닉네임 " + nickname);

        Member m = memberRepository.findByEmail(email);
        if (m == null) {
            System.out.println("회원 없음");
            m = Member.createMember(email, name, nickname);
            memberRepository.save(m);
        }

        return new PrincipalDetails(m, oauth2user.getAttributes());
    }
}
