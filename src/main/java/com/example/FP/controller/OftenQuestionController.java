package com.example.FP.controller;

import com.example.FP.entity.OftenQuestion;
import com.example.FP.service.OftenQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class OftenQuestionController {

    private final OftenQuestionService oftenQuestionService;

    @Autowired
    public OftenQuestionController(OftenQuestionService oftenQuestionService) {
        this.oftenQuestionService = oftenQuestionService;
    }
//자주묻는 질문 목록
    @GetMapping("/oftenQuestions")
    public String getAllQuestions(Model model) {
        String View = "oftenQuestionList";
        List<OftenQuestion> questions = oftenQuestionService.getAllQuestions();
        model.addAttribute("questions" ,questions);
        return View;
    }

    @GetMapping("/oftenQuestionDetail/{id}")
    public String getOftenQuestionAnswer(@PathVariable Long id, Model model) {
        OftenQuestion question = oftenQuestionService.getQuestionById(id);
        if (question != null) {
            model.addAttribute("question", question);
            return "oftenQuestionDetail"; // 해당 경로의 Thymeleaf 뷰 페이지
        } else {
            return "errorPage"; // 질문이 존재하지 않을 경우 에러 페이지로 리디렉션
        }
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<OftenQuestion> createQuestion(@RequestBody OftenQuestion question) {
        OftenQuestion createdQuestion = oftenQuestionService.createQuestion(question);
        return new ResponseEntity<>(createdQuestion, HttpStatus.CREATED);
    }



    // 자주 묻는 질문을 삭제하는 메서드
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuestion(@PathVariable Long id) {
        oftenQuestionService.deleteQuestion(id);
        return ResponseEntity.noContent().build();
    }

}
