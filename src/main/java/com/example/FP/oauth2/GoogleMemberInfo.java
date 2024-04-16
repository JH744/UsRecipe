package com.example.FP.oauth2;

import java.util.Map;

public class GoogleMemberInfo implements OAuth2MemberInfo {
    private Map<String, Object> attributes;

    public GoogleMemberInfo(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    @Override
    public String getProviderId() {
        return attributes.get("sub").toString();
    }

    @Override
    public String getProvider() {
        return "google";
    }

    @Override
    public String getName() {
        return attributes.get("name").toString();
    }

    @Override
    public String getEmail() {
        return attributes.get("email").toString();
    }

    @Override
    public String getPhone(){
       return null;
    }

    @Override
    public String getNickname(){
        return null;
    }

    @Override
    public String getBirth(){
        return null;
    }
}
