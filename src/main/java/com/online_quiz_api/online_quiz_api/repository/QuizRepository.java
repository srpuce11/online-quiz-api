package com.online_quiz_api.online_quiz_api.repository;

import com.online_quiz_api.online_quiz_api.repository.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
    List<Quiz> getQuizByTeacherId(int teacherId);
}