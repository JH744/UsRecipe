package com.example.FP.handler;

import com.example.FP.entity.Member;
import com.example.FP.service.MemberService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;


// 로그인 성공시 핸들러
@Component
@RequiredArgsConstructor
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    private final MemberService ms;
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        System.out.println("핸들러");
        HttpSession session = request.getSession();
        if (session != null) {
            // 로그인 페이지로 이동전에 있던 홈페이지 url를 가져옴
            String prevPage = (String) session.getAttribute("prevPage");
            System.out.println(prevPage);
            // authentication.getPrincipal()은 로그인한 사용자를 나타냅니다.
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String username = userDetails.getUsername();
            Member m = ms.findById(username);
            String role = String.valueOf(m.getRole());
            session.setAttribute("userid", username);
            session.setAttribute("image", m.getImage());
            session.setAttribute("role", m.getRole().toString());
            if (role.equals("ADMIN")) {
                response.sendRedirect("/admin/adminMember");
                return;
            }
            if (prevPage != null && !prevPage.isEmpty() && !prevPage.contains("join")) {
                // 이전 페이지로 리다이렉트
                response.sendRedirect(prevPage);
                return;
            }


        }

        response.sendRedirect("/");
    }
}
