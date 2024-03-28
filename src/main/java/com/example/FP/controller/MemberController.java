package com.example.FP.controller;

import com.example.FP.entity.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {

    @GetMapping("/join")
    public String join(Member member, Model model){
        model.addAttribute("member",member);
        return "join";

    }
}
