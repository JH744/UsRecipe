package com.example.FP.controller;

import com.example.FP.dto.InquiryDto;
import com.example.FP.entity.Inquiry;
import com.example.FP.entity.OftenQuestion;
import com.example.FP.mapper.InquiryMapper;
import com.example.FP.service.InquiryService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class InquiryController {

    private final InquiryService is;

    @GetMapping("/insertInquiry")
    public String inquiryForm(){
        return "/user/inquiryForm";

    }
    @PostMapping("/insertInquiry")
    public String inquirySubmit(InquiryDto inquiryDto){
        is.save(InquiryMapper.toEntity(inquiryDto));
        return "redirect:/user/inquiryList";


    }

    @GetMapping("/inquiryDetail/{id}")
    public String showInquiryDetail(@PathVariable("id") Long id, Model model) {
        Optional<Inquiry> inquiryOptional = is.findById(id);

        if (inquiryOptional.isPresent()) {
            model.addAttribute("inquiry", inquiryOptional.get());
            return "user/inquiryDetail"; // 'inquiryDetail.html' 뷰로 이동
        } else {
            return "redirect:/errorPage"; // 오류 페이지로 리다이렉트
        }
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
