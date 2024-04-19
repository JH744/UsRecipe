package com.example.FP.handler;

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

@Component
@RequiredArgsConstructor
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    private final MemberService ms;
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        System.out.println("핸들러");
        HttpSession session = request.getSession();
        if (session != null) {
            String prevPage = (String) session.getAttribute("prevPage");
            System.out.println(prevPage);
            // authentication.getPrincipal()은 로그인한 사용자를 나타냅니다.
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String username = userDetails.getUsername();
            session.setAttribute("userid", username);
            session.setAttribute("image", ms.findById(username).getImage());
            if (prevPage != null && !prevPage.isEmpty()) {
                // 이전 페이지로 리다이렉트합니다.
                response.sendRedirect(prevPage);
                return;
            }
        }

        response.sendRedirect("/");
    }
}
