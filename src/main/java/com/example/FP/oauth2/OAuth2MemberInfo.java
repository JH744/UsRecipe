package com.example.FP.oauth2;

public interface OAuth2MemberInfo {
    String getProviderId(); //공급자 아이디 ex) google, facebook
    String getProvider(); //공급자 ex) google, facebook
    String getName(); //사용자 이름 ex) 홍길동
    String getEmail(); //사용자 이메일 ex) gildong@gmail.com

    String getPhone(); // 사용자 핸드폰 번호

    String getNickname(); // 사용자 닉네임

    String getBirth(); // 사용자 생년월일
}
