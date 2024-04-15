package com.example.FP.controller;

import com.example.FP.dto.MemberDto;
import com.example.FP.entity.Member;
import com.example.FP.service.MailService;
import com.example.FP.service.MemberService;
import com.example.FP.service.OrdersService;
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

    private final OrdersService os;
    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;
    private final MailService mailService;
    private int number; // 이메일 인증 숫자를 저장하는 변수


    // 로그인 폼
    @GetMapping("/login")
    public void loginForm(){}

    // 회원가입 폼
    @GetMapping("/join")
    public String joinForm(Model model){
        System.out.println("회원가입 하기");
        model.addAttribute("memberFormDto", new MemberDto());

        return "/join";
    }

    // 회원가입
    @PostMapping("/join")
    public String joinSubmit(@ModelAttribute(name = "memberFormDto") MemberDto memberFormDto,
                             String addr1,
                             String addr2,
                             String year,
                             String month,
                             String day
                             ){
        System.out.println("회원가입 완료");
        System.out.println(memberFormDto.getUserid());


        String addr = addr1 + " " + addr2; // 주소와 상세 주소 합치기
        String birth = year + month + day; // 생년월일
        memberFormDto.setAddr(addr);
        memberFormDto.setBirth(birth);
        Member member = Member.createMember(memberFormDto, passwordEncoder);
        memberService.join(member);

        return "redirect:/joinOk";
    }
    
    // 회원가입시 아이디 중복 체크
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

    // 회원가입시 닉네임 중복 체크
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


    // 회원가입 완료 후
    @GetMapping("/joinOk")
    public String joinOk(){
        return "/joinOk";
    }

    // 아이디 찾기
    @GetMapping("/all/findUserid")
    public String findIdForm(){ return "/all/findUserid"; }
    
    // 아이디 찾기
    @PostMapping("/all/findUserid")
    public String findIdSubmit(@RequestParam String name, @RequestParam String email, Model model){
        String toEmail = email.replace("%40", "@").trim(); // 이메일 가져오기
        HashMap<String, String > map = memberService.findByNameAndEmail(name, toEmail);
        if (map.get("success").equals("false")) {
            return "redirect:/all/findUserid";
        }

        model.addAttribute("name", name);
        model.addAttribute("userid", map.get("userid"));

        return "/findUseridOk";
    }

    // 비밀번호 찾기
    @GetMapping("/all/findUserPwd")
    public String findPwdForm(){ return "/all/findPwd"; }

    // 비밀번호 찾기
    @PostMapping("/all/findUserPwd")
    public String findPwdSubmit(@RequestParam String userid, @RequestParam String email, Model model){
        System.out.println("비밀번호 찾기 클릭");
        String toEmail = email.replace("%40", "@").trim();
        Boolean res = memberService.findByUseridAndEmail(userid, toEmail);
        if (!res) {
            return "redirect:/all/findUserPwd";
        }

        try {
            number = mailService.sendMail(toEmail);
            String num = String.valueOf(number);
            model.addAttribute("userid", userid);
            model.addAttribute("num", num);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "/all/emailAuthentication";
    }

    // 비밀번호 찾기시 이메일 인증
    @PostMapping("/all/emailAuthentication")
    public String emailAuthentication(@RequestParam String userid, Model model){
        model.addAttribute("userid", userid);
        return "/newPwd";
    }

    // 새 비밀번호 설정
    @GetMapping("/all/newPwd")
    public String pwChangeForm(){
        return "/all/newPwd";
    }

    // 새 비밀번호 설정
    @PostMapping("/all/newPwd")
    public String pwChangeSubmit(@RequestParam String userid, @RequestParam String password){
        Member m = memberService.findById(userid);
        if (m != null) {
            m.newPwd(passwordEncoder.encode(password));
            memberService.save(m);
            return "/all/findPwdOk";
        }

        return "/index";
    }

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
    @GetMapping("/orderList")
    public String orderList(Model model,HttpSession session){

        return "/orderList";

    }


}
