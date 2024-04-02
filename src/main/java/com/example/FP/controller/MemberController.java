package com.example.FP.controller;

import com.example.FP.dto.MemberDto;
import com.example.FP.entity.Member;
import com.example.FP.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    private final PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public void loginForm(){}


    @GetMapping("/join")
    public void joinForm(Model model){
        System.out.println("회원가입 하기");
        model.addAttribute("memberFormDto", new MemberDto());
    }

    @PostMapping("/join")
    public String joinSubmit(@Valid @ModelAttribute("memberFormDto") MemberDto memberFormDto, BindingResult bindingResult){
        System.out.println("회원가입 들어옴");
        System.out.println(memberFormDto.getUserid());
        if(bindingResult.hasErrors()){
            System.out.println("에러");
            return "join";
        }

        Member member = Member.createMember(memberFormDto, passwordEncoder);
        memberService.join(member);

        return "redirect:/joinOk";
    }

    @GetMapping("/joinOk")
    public void joinOk(){}

    @GetMapping("/findID")
    public void findId(){}

    @GetMapping("/findPwd")
    public void findPwd(){}

    @GetMapping("/pwChange")
    public void pwChange(){}

    @GetMapping("/pwFindEmailCerti")
    public void pwFindEmailCerti(){}

}
