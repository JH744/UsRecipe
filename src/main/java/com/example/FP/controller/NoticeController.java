package com.example.FP.controller;

import com.example.FP.dto.NoticeDto;
import com.example.FP.entity.Notice;
import com.example.FP.mapper.NoticeMapper;
import com.example.FP.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@Controller
@RequiredArgsConstructor
public class NoticeController {

    private final NoticeService ns;

    @GetMapping("/notice")
    public String noticeList(Model model){
        model.addAttribute("list", ns.findAll());
        return "/all/notice";
    }

    @GetMapping("/admin/noticeList")
    public String adminNoticeList(Model model){
        model.addAttribute("list", ns.findAll());
        return "/admin/adminNoticeList";
    }

    @GetMapping("/admin/noticeInsert")
    public String noticeForm(Model model, NoticeDto noticeDto){
        model.addAttribute("notice", noticeDto);
        return "/admin/adminNoticeForm";
    }

    @PostMapping("/admin/noticeInsert")
    public String noticeSubmit(NoticeDto noticeDto){
        noticeDto.setNotice_submit_date(LocalDateTime.now());
        ns.save(NoticeMapper.toEntity(noticeDto));
        return "redirect:/admin/noticeList";
    }

    @GetMapping("/noticeDetail/{id}")
    public String noticeDetail(@PathVariable Long id, Model model){
        Notice notice = ns.findById(id).orElseThrow(() -> new NoSuchElementException("No notice found for ID " + id));
        model.addAttribute("notice", notice);
        return "/all/noticeDetail";
    }
    @GetMapping("/admin/noticeUpdate/{id}")
    public String noticeUpdateForm(@PathVariable Long id, Model model){
        Notice n = ns.findById(id).get();
        model.addAttribute("list", n);
        return "/admin/adminNoticeUpdate";
    }

    @PostMapping("/admin/noticeUpdate")
    public String noticeUpdateSubmit(@RequestParam Long id, @RequestParam String title, @RequestParam String content){
        Notice n = ns.findById(id).get();
        n.update(title, content, LocalDateTime.now());
        ns.save(n);
        return "redirect:/admin/noticeList";
    }

    @GetMapping("/admin/noticeDelete/{id}")
    public String noticeDelete(@PathVariable Long id) {
        ns.deleteNotice(id);
        return "redirect:/admin/noticeList";
    }


}
