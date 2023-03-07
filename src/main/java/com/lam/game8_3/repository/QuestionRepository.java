package com.lam.game8_3.repository;

import com.lam.game8_3.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
    Question getQuestionById(Integer id);
}
