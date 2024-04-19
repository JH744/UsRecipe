package com.example.FP.controller;

import com.example.FP.dto.InquiryDto;
import com.example.FP.entity.Inquiry;
import com.example.FP.entity.Member;
import com.example.FP.entity.OftenQuestion;
import com.example.FP.mapper.InquiryMapper;
import com.example.FP.service.InquiryService;
import com.example.FP.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class InquiryController {

    private final InquiryService is;
    private final MemberService ms;

    @PostMapping("/insertInquiry")
    public String inquirySubmit(InquiryDto inquiryDto,HttpSession session) {
        inquiryDto.setInquiry_member(ms.findById((String)session.getAttribute("userid")));
        Inquiry inquiry = InquiryMapper.toEntity(inquiryDto);
        is.save(inquiry);
        return "redirect:/user/inquiryList"; // 성공적으로 등록 후, 문의 목록 페이지로 리다이렉션
    }
    @GetMapping("/insertInquiry")
    public String showInquiryForm(Model model,InquiryDto inquiryDto) {


        model.addAttribute("inquiryDto", inquiryDto); // 설정된 DTO를 모델에 추가
        return "user/inquiryForm"; // inquiryForm.html 뷰 반환
    }



    @GetMapping("/user/inquiryList")
    public String showInquiryList(Model model) {
        // 문의 목록을 조회하는 서비스 호출
        List<Inquiry> inquiries = is.findAll();
        model.addAttribute("inquiries", inquiries);
        return "/user/inquiryList"; // 뷰 이름 반환
    }

//    @PostMapping("/insertInquiry")
//    public String inquirySubmit(InquiryDto inquiryDto){
//        is.save(InquiryMapper.toEntity(inquiryDto));
//        return "redirect:/user/inquiryList";
//
//
//    }

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
