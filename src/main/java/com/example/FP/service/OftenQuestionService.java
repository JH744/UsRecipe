package com.example.FP.service;

import com.example.FP.entity.OftenQuestion;
import com.example.FP.repository.OftenQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OftenQuestionService {

    private final OftenQuestionRepository oftenQuestionRepository;

    @Autowired
    public OftenQuestionService(OftenQuestionRepository oftenQuestionRepository) {
        this.oftenQuestionRepository = oftenQuestionRepository;
    }

    // 모든 자주 묻는 질문을 반환
    public List<OftenQuestion> getAllQuestions() {
        return oftenQuestionRepository.findAll();
    }

    // ID로 자주 묻는 질문을 조회
    public OftenQuestion getQuestionById(Long id) {
        Optional<OftenQuestion> question = oftenQuestionRepository.findById(id);
        return question.orElse(null);
    }

    // 새로운 자주 묻는 질문 생성
    public OftenQuestion createQuestion(OftenQuestion question) {
        return oftenQuestionRepository.save(question);
    }



    // 자주 묻는 질문 삭제
    public void deleteQuestion(Long id) {
        oftenQuestionRepository.deleteById(id);
    }
}
