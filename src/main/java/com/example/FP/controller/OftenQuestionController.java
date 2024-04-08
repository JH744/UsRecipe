package com.example.FP.controller;

import com.example.FP.entity.OftenQuestion;
import com.example.FP.service.OftenQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/oftenQuestions")
public class OftenQuestionController {

    private final OftenQuestionService oftenQuestionService;

    @Autowired
    public OftenQuestionController(OftenQuestionService oftenQuestionService) {
        this.oftenQuestionService = oftenQuestionService;
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<OftenQuestion>> getAllQuestions() {
        List<OftenQuestion> questions = oftenQuestionService.getAllQuestions();
        return ResponseEntity.ok(questions);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<OftenQuestion> getQuestionById(@PathVariable Long id) {
        OftenQuestion question = oftenQuestionService.getQuestionById(id);
        return ResponseEntity.ok(question);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<OftenQuestion> createQuestion(@RequestBody OftenQuestion question) {
        OftenQuestion createdQuestion = oftenQuestionService.createQuestion(question);
        return new ResponseEntity<>(createdQuestion, HttpStatus.CREATED);
    }

    // 자주 묻는 질문을 업데이트하는 메서드
    @PutMapping("/{id}")
    public ResponseEntity<OftenQuestion> updateQuestion(@PathVariable Long id, @RequestBody OftenQuestion questionDetails) {
        OftenQuestion updatedQuestion = oftenQuestionService.updateQuestion(id, questionDetails);
        return ResponseEntity.ok(updatedQuestion);
    }

    // 자주 묻는 질문을 삭제하는 메서드
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuestion(@PathVariable Long id) {
        oftenQuestionService.deleteQuestion(id);
        return ResponseEntity.noContent().build();
    }

}
