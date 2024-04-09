package com.example.FP.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class KakaoLoginController {
    private final String KakaoKey = System.getenv("kakao_api_key");

    @Value("${kakao.redirect_uri}")
    private String redirect_uri;


    @GetMapping("/kakaoLogin")
    public String loginPage(Model model) {
        String location = "https://kauth.kakao.com/oauth/authorize?response_type=code&client_id="+KakaoKey+"&redirect_uri="+redirect_uri;
        model.addAttribute("location", location);

        return location;
    }
}
