package com.example.FP.controller;

import com.example.FP.entity.InquiryState;
import com.example.FP.service.InquiryService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class InquiryController {

    private final InquiryService is;



    @GetMapping("/inquiryList")
    public String inquiryList(Model model, HttpSession session){
        model.addAttribute("list",is.findByUserid((String)session.getAttribute("userid")));

        return "/inquiryList";

    }

}
