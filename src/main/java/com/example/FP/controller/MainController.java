package com.example.FP.controller;

import com.example.FP.entity.Member;
import com.example.FP.service.MemberService;
import com.example.FP.service.RecipeService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final MemberService ms;
    private final RecipeService rs;

    @GetMapping("/")
    public String index(HttpSession session, Model model, @AuthenticationPrincipal OAuth2User oauth){
        System.out.println("홈");
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.isAuthenticated() && authentication.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String username = userDetails.getUsername();
            Member m =  ms.findById(username);
            session.setAttribute("userid", username);
            session.setAttribute("image", m.getImage());
            session.setAttribute("role", m.getRole());

            System.out.println(username);
            System.out.println("OAuth2User:" + oauth.getAttributes());
        }

        model.addAttribute("recipe_list", rs.top5());
        model.addAttribute("member_list", ms.findTop5());
        model.addAttribute("random_list", rs.randomList());

        return "index";

    }
}
