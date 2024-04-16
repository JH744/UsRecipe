package com.example.FP.controller;

import com.example.FP.dto.NoticeDto;
import com.example.FP.mapper.NoticeMapper;
import com.example.FP.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class NoticeController {

    private final NoticeService ns;

    @GetMapping("/notice")
    public String noticeList(Model model){
        model.addAttribute("list", ns.findAll());
        return "/notice";
    }

    @GetMapping("/noticeInsert")
    public String noticeForm(){
        return "/noticeForm";
    }

    @PostMapping("/noticeInsert")
    public String noticeSubmit(NoticeDto noticeDto){
        ns.save(NoticeMapper.toEntity(noticeDto));
        return "redirect:/notice";
    }

    @GetMapping("/noticeDetail/{id}")
    public String noticeDetail(@PathVariable Long id, Model model){
        model.addAttribute("list", ns.findById(id));
        return "/noticeDetail";
    }

    @GetMapping("/noticeUpdate/{id}")
    public String noticeUpdateForm(@PathVariable Long id, Model model){
        model.addAttribute("list", ns.findById(id));
        return "/noticeUpdate";
    }

    @PostMapping("/noticeUpdate")
    public String noticeUpdateSubmit(NoticeDto noticeDto){
        ns.save(NoticeMapper.toEntity(noticeDto));
        return "redirect:/notice";
    }

    @GetMapping("/noticeDelete/{id}")
    public String noticeDelete(@PathVariable Long id) {
        ns.deleteNotice(id);
        return "redirect:/notice";
    }
}
