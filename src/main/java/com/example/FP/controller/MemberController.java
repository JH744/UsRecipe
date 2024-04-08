package com.example.FP.controller;

import com.example.FP.dto.MemberDto;
import com.example.FP.entity.Member;
import com.example.FP.service.MailService;
import com.example.FP.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;
    private final MailService mailService;
    private int number; // 이메일 인증 숫자를 저장하는 변수



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

    @GetMapping("/findUserid")
    public String findIdForm(){ return "/findUserid"; }

    @PostMapping("/findUserid")
    public String findIdSubmit(@RequestParam String name, @RequestParam String email, Model model){
        String toEmail = email.replace("%40", "@").trim();
        HashMap<String, String > map = memberService.findByNameAndEmail(name, toEmail);
        if (map.get("success").equals("false")) {
            return "redirect:/findUserid";
        }


        model.addAttribute("name", name);
        model.addAttribute("userid", map.get("userid"));

        return "/findUseridOk";
    }

    @GetMapping("/findPwd")
    public String findPwdForm(){ return "/findPwd"; }

    @PostMapping("/findPwd")
    public String fingPwdSubmit(@RequestParam String userid, @RequestParam String email, Model model){
        String toEmail = email.replace("%40", "@").trim();
        Boolean res = memberService.findByUseridAndEmail(userid, toEmail);
        if (!res) {
            return "/findPwd";
        }

        try {
            number = mailService.sendMail(toEmail);
            String num = String.valueOf(number);
            model.addAttribute("userid", userid);
            model.addAttribute("num", num);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "/emailAuthentication";
    }

    @PostMapping("/emailAuthentication")
    public String emailAuthentication(){

        return "/findPwdOk";
    }

    @GetMapping("/pwChange")
    public String pwChange(){ return "/newPwd"; }

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
