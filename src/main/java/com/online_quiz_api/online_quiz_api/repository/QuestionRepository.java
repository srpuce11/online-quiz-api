package com.online_quiz_api.online_quiz_api.repository;

import com.online_quiz_api.online_quiz_api.repository.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}