package com.lam.game8_3.service.impl;

import com.lam.game8_3.model.Question;
import com.lam.game8_3.repository.QuestionRepository;
import com.lam.game8_3.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionImpl implements QuestionService {
    @Autowired
    QuestionRepository questionRepository;

    @Override
    public Question getQuestionById(Integer id) {
        return questionRepository.getQuestionById(id);
    }
}
