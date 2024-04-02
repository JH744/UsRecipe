package com.example.FP.controller;

import com.example.FP.dto.MemberDto;
import com.example.FP.entity.Member;
import com.example.FP.mapper.MemberMapper;
import com.example.FP.repository.MemberRepository;
import com.example.FP.service.MemberService;
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


    private final MemberRepository memberRepository;
    private final MemberService memberService;
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
        memberService.join(memberDto);


        return null;
    }
    @GetMapping("/dataChange")
    public String dataChangeForm(){
        return "/dataChange";
    }




}
