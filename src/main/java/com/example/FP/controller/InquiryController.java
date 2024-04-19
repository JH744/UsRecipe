package com.example.FP.controller;

import com.example.FP.dto.InquiryDto;
import com.example.FP.mapper.InquiryMapper;
import com.example.FP.service.InquiryService;
import com.example.FP.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class InquiryController {

    private final InquiryService is;
    private final MemberService ms;

    @GetMapping("/insertInquiry")
    public String inquiryForm(Model model,InquiryDto inquiryDto){
        model.addAttribute("inquiry",inquiryDto);
        return "/user/inquiryForm";

    }
    @PostMapping("/insertInquiry")
    public String inquirySubmit(InquiryDto inquiryDto,HttpSession session){

        is.save(InquiryMapper.toEntity(inquiryDto),ms.findById((String)session.getAttribute("userid")));
        return "redirect:/inquiryList";
    }



    @GetMapping("/inquiryList")
    public String inquiryList(Model model, HttpSession session){
        model.addAttribute("list",is.findByUserid((String)session.getAttribute("userid")));

        return "/user/inquiryList";

    }
    @PostMapping("/deleteInquiry/{id}")
    public String deleteInquiry(@PathVariable Long id){
        is.deleteInquiry(id);

        return "redirect:/user/inquiryList";
    }

}
