package com.example.FP.controller;

import com.example.FP.dto.MemberDto;
import com.example.FP.entity.Member;
import com.example.FP.mapper.MemberMapper;
import com.example.FP.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    private final PasswordEncoder passwordEncoder;



    @GetMapping("/login")
    public void loginForm(){}


    @GetMapping("/join")
    public String joinForm(Model model){
        System.out.println("회원가입 하기");
        model.addAttribute("memberFormDto", new MemberDto());

        return "/join";
    }

    @PostMapping("/join")
    public String joinSubmit(@ModelAttribute(name = "memberFormDto") MemberDto memberFormDto,
                             String addr1,
                             String addr2,
                             String year,
                             String month,
                             String day
                             ){
        System.out.println("회원가입 와뇨");
        System.out.println(memberFormDto.getUserid());


        String addr = addr1 + " " + addr2;
        String birth = year + month + day;
        memberFormDto.setAddr(addr);
        memberFormDto.setBirth(birth);
        Member member = Member.createMember(memberFormDto, passwordEncoder);
        memberService.join(member);

        return "redirect:/joinOk";
    }

    @PostMapping("/id_check")
    @ResponseBody
    public String checkId(@RequestBody String userid){
        System.out.println("아이디중복");
        Boolean res = memberService.findByUserid(userid);
        if (res) {
            System.out.println("실패");
            return "fail";
        }
        System.out.println("성공");
        return "success";
    }

    @PostMapping("/nickname_check")
    @ResponseBody
    public String checkNickname(@RequestBody String nickname){
        System.out.println(nickname);
        System.out.println("이메일중복 확인");
        Boolean res = memberService.findByNickname(nickname);
        if (res) {
            System.out.println("실패");
            return "fail";
        }
        System.out.println("성공");
        return "success";
    }


    @GetMapping("/joinOk")
    public String joinOk(){
        return "/joinOk";
    }

    @GetMapping("/findID")
    public void findId(){}

    @GetMapping("/findPwd")
    public void findPwd(){}

    @GetMapping("/pwChange")
    public void pwChange(){}

    @GetMapping("/pwFindEmailCerti")
    public void pwFindEmailCerti(){}

    @GetMapping("/pwCheckDataChange")
    public String pwCheckDataChangeForm(){



        return "/pwCheckDataChange";
    }
    @PostMapping("/pwCheckDataChange")
    @ResponseBody
    public Boolean pwCheckDataChangeSubmit(HttpSession session, @RequestParam String password){
        String id = (String)session.getAttribute("userid");
        String pw = memberService.pwCheck(id);
        System.out.println("입력 비번 : " + password);
        boolean matches = passwordEncoder.matches(password, pw);

        return matches;

    }
    @GetMapping("/dataChange")
    public String dataChangeForm(Model model,MemberDto memberDto){
        model.addAttribute("memberDto",memberDto);
        return "/dataChange";
    }
    @PostMapping("/dataChange")
    public String dataChangeSubmit(MemberDto memberDto){

        Member member = Member.createMember(memberDto,passwordEncoder);
        memberService.dataChange(member);

//        String addr = addr1 + " " + addr2;
//        String birth = year + month + day;
//        memberFormDto.setAddr(addr);
//        memberFormDto.setBirth(birth);
//        Member member = Member.createMember(memberFormDto, passwordEncoder);
//        memberService.join(member);

        return "redirect:/";

    }


}
