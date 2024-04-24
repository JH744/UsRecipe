package com.example.FP.controller;

import com.example.FP.service.MailService;
import com.example.FP.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@Controller
@RequiredArgsConstructor
public class MailController {

    private final MailService mailService;
    private final MemberService memberService;
    private int number; // 이메일 인증 숫자를 저장하는 변수

    // 인증 이메일 전송
    @PostMapping("/sendEmail")
    @ResponseBody
    public HashMap<String, Object> mailSend(@RequestBody String email){
        HashMap<String, Object> map = new HashMap<>();
        String toEmail = email.replace("%40", "@").trim();
        Boolean res = memberService.findByEmail(toEmail);
        try {
            if (!res) {
                number = mailService.sendMail(toEmail);
                String num = String.valueOf(number);
                map.put("success", "success");
                map.put("number", num);
            } else {
                map.put("success", "fail");
            }
        } catch (Exception e) {
            map.put("success", "fail");
            map.put("error", e.getMessage());
        }

        return map;
    }

    // 인증번호 일치여부 확인
    @PostMapping("/mailCheck")
    @ResponseBody
    public String mailCheck(@RequestBody String authCode) {
        boolean isMatch = authCode.equals(String.valueOf(number));
        if (isMatch) return "success";
        return "fail";
    }

}
