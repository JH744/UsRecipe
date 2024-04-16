package com.example.FP.oauth2;

import java.util.Map;

public class NaverMemberInfo implements OAuth2MemberInfo {
    private Map<String, Object> attributes;
    private Map<String, Object> naverAccountAttributes;

    public NaverMemberInfo(Map<String, Object> attributes) {
        this.attributes = attributes;
        this.naverAccountAttributes = (Map<String, Object>) attributes.get("response");
    }

    @Override
    public String getProviderId() {
        return attributes.get("id").toString();
    }

    @Override
    public String getProvider() {
        return "naver";
    }

    @Override
    public String getName() {
        return naverAccountAttributes.get("name").toString();
    }

    @Override
    public String getEmail() {
        return naverAccountAttributes.get("email").toString();
    }

    @Override
    public String getPhone(){
        String phone = "";
        phone += naverAccountAttributes.get("mobile").toString().substring(0, 3);
        phone += naverAccountAttributes.get("mobile").toString().substring(4, 8);
        phone += naverAccountAttributes.get("mobile").toString().substring(9);
        return phone;
    }

    @Override
    public String getNickname(){
        return naverAccountAttributes.get("nickname").toString();
    }

    @Override
    public String getBirth(){
        String birth = "";
        String month = naverAccountAttributes.get("birthday").toString().substring(0,2);
        String day = naverAccountAttributes.get("birthday").toString().substring(3);
        String year = naverAccountAttributes.get("birthyear").toString();
        birth = year+month+day;

        return birth;
    }
}
