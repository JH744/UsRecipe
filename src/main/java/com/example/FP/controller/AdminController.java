package com.example.FP.controller;

import com.example.FP.dto.InquiryDto;
import com.example.FP.entity.Inquiry;
import com.example.FP.entity.InquiryState;
import com.example.FP.mapper.InquiryMapper;
import com.example.FP.service.InquiryService;
import com.example.FP.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final MemberService ms;
    private final InquiryService is;

    @GetMapping("/member")
    public String adminMemberForm(Model model){
        model.addAttribute("list",ms.findAllMember());
        return "/admin/adminMember";


    }
    @GetMapping("/inquiry")
    public String adminInquiryForm(Model model){
        model.addAttribute("answered",is.answered());
        model.addAttribute("yet",is.answeredYet());

        return"/admin/adminInquiry";
    }
    @GetMapping("/inquiryDetail/{id}")
    public String adminInquiryDetailForm(Model model, @PathVariable Long id){


        model.addAttribute("list",is.listById(id));

        return "/admin/adminInquiryDetail";
    }

    @PostMapping("/inquiryDetail")
    public String adminInquiryDetailSubmit(@RequestParam Long id){

        is.updateInquiry(id);

        return "redirect:/admin/inquiry";

    }

    @GetMapping("/deleteInquiry/{id}")
    public String deleteInquiry(@PathVariable Long id){
        is.deleteInquiry(id);

        return "redirect:/admin/inquiry";
    }


}
