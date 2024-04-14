package com.example.FP.controller;

import com.example.FP.service.MemberService;
import com.example.FP.service.RecipeService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final MemberService ms;
    private final RecipeService rs;

    @GetMapping("/")
    public String index(HttpSession session, Model model){
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.isAuthenticated() && authentication.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String username = userDetails.getUsername();
            session.setAttribute("userid", username);
            System.out.println(username);
        }

        model.addAttribute("recipe_list", rs.top5());
        model.addAttribute("random_list", rs.randomList());

        return "index";

    }

    @GetMapping("/template")
    public void template(){

    }
}
