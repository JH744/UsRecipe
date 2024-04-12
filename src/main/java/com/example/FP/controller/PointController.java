package com.example.FP.controller;

import com.example.FP.service.PointService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class PointController {

    private final PointService ps;

    @GetMapping("/pointList")
    public String listPoint(Model model, HttpSession session){
        String userid = (String)session.getAttribute("userid");

        model.addAttribute("list",ps.findPointListByUserid(userid));
        return "/pointList";

    }
}
