package com.example.FP.controller;

import com.example.FP.repository.MemberRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String index(HttpSession session){
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null) {
            User user = (User)authentication.getPrincipal();
            String userid = user.getUsername();
            session.setAttribute("userid", userid);
            System.out.println(userid);
        }

        return "index";
    }
}
