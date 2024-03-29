package com.example.FP.controller;

import com.example.FP.dto.MemberDto;
import com.example.FP.entity.Member;
import com.example.FP.mapper.MemberMapper;
import com.example.FP.repository.MemberRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

@Controller
@RequiredArgsConstructor
public class MemberController {


    private final MailSender mailSender;
    private final MemberRepository memberRepository;
    @GetMapping("/join")
    public String join(Member member, Model model){
        model.addAttribute("member",member);
        return "join";

    }
    @PostMapping("/join")
    public String joinSubmit(@Valid MemberDto memberDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "join";
        }
        Member member = MemberMapper.toEntity(memberDto);
        memberRepository.save(member);

        return null;
    }

    @GetMapping("/sendCodeEmail")
    @ResponseBody
    public String sendCodeEmail(String email){
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("tjfkqm1@gmail.com");
        mailMessage.setTo(email);
        mailMessage.setSubject("인증번호");

        Random r = new Random();
        int a = r.nextInt(10);
        int b = r.nextInt(10);
        int c = r.nextInt(10);
        int d = r.nextInt(10);

        String text = "회원님의 인증번호는 ";
        String data = a+""+b+""+c+""+d;

        mailMessage.setText(text+data);
        try {
            mailSender.send(mailMessage);
        }catch(Exception e) {
            System.out.println("메일전송 오류 발생 : " + e.getMessage());
        }

        return data;
    }
}
