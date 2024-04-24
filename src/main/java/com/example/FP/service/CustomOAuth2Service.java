package com.example.FP.service;

import com.example.FP.details.PrincipalDetails;
import com.example.FP.dto.MemberDto;
import com.example.FP.entity.Member;
import com.example.FP.entity.MemberRole;
import com.example.FP.oauth2.GoogleMemberInfo;
import com.example.FP.oauth2.KakaoMemberInfo;
import com.example.FP.oauth2.NaverMemberInfo;
import com.example.FP.oauth2.OAuth2MemberInfo;
import com.example.FP.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    private final PasswordEncoder passwordEncoder;

    // OAuth2를 이용한 소셜로그인
    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        // OAuth 서비스(kakao, google, naver)에서 가져온 유저 정보를 담고있음
        OAuth2User oauth2user = super.loadUser(userRequest);
        OAuth2MemberInfo oAuth2MemberInfo = null;


//        String userNameAttributeName = userRequest.getClientRegistration()
//                .getProviderDetails()
//                .getUserInfoEndpoint()
//                .getUserNameAttributeName(); // OAuth 로그인 시 키(pk)가 되는 값
//        Map<String, Object> attributes = oauth2user.getAttributes(); // OAuth 서비스의 유저 정보들
//        System.out.println(userNameAttributeName);

//        HashMap<String, Object> account = (HashMap<String, Object>) attributes.get("kakao_account");
//        HashMap<String, Object> profile = (HashMap<String, Object>) account.get("profile");
//        String name = (String) profile.get("nickname");
//        String email = (String) account.get("email");
//        String nickname = "kakao_" + attributes.get("id");
//
//        System.out.println("이름 " + name);
//        System.out.println("이메일 " + email);
//        System.out.println("닉네임 " + nickname);

        String registrationId = userRequest.getClientRegistration().getRegistrationId(); // 소셜로그인 provide를 가져옴
        // if문을 통해 소셜로그인 구분
        if (registrationId.equals("kakao")) {
            oAuth2MemberInfo = new KakaoMemberInfo(oauth2user.getAttributes());
        } else if (registrationId.equals("naver")) {
            oAuth2MemberInfo = new NaverMemberInfo(oauth2user.getAttributes());
        } else if (registrationId.equals("google")) {
            oAuth2MemberInfo = new GoogleMemberInfo(oauth2user.getAttributes());
        }

        String email = oAuth2MemberInfo.getEmail();
        String name = oAuth2MemberInfo.getName();
        String nickname = oAuth2MemberInfo.getNickname();
        if (nickname == null) {
            nickname = oAuth2MemberInfo.getProvider() + "_" + oAuth2MemberInfo.getProviderId();
        }
        String phone = oAuth2MemberInfo.getPhone();
        String birth = oAuth2MemberInfo.getBirth();

        Member m = memberRepository.findByEmail(email);
        if (m == null) {
            MemberDto memberDto = new MemberDto(
                    name,
                    email,
                    nickname,
                    birth,
                    phone
            );
            m = Member.createMember(memberDto);
            memberRepository.save(m);
        }

        return new PrincipalDetails(m, oauth2user.getAttributes());
    }
}
