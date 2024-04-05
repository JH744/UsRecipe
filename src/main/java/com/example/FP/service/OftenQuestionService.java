package com.example.FP.service;

import com.example.FP.entity.OftenQuestion;
import com.example.FP.repository.OftenQuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OftenQuestionService {

    private final OftenQuestionRepository oftenQuestionRepository;
    public List<OftenQuestion> getAllQuestions() {
        return oftenQuestionRepository.findAll();
    }

    public OftenQuestion getQuestionById(Long id) {
        // 여기서 Optional을 사용해 결과가 없을 경우 null을 반환합니다.
        return oftenQuestionRepository.findById(id).orElse(null);
    }

    public OftenQuestion createQuestion(OftenQuestion question) {
        // 여기에 입력 데이터 검증 로직을 추가할 수 있습니다.
        return oftenQuestionRepository.save(question);
    }

    public OftenQuestion updateQuestion(Long id, OftenQuestion questionDetails) {
        OftenQuestion question = getQuestionById(id);
        // question 객체를 questionDetails로 업데이트합니다.
        return oftenQuestionRepository.save(question);
    }

    public void deleteQuestion(Long id) {
        OftenQuestion question = getQuestionById(id);
        oftenQuestionRepository.delete(question);
    }
}