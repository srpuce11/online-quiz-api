package com.online_quiz_api.online_quiz_api.repository;


import com.online_quiz_api.online_quiz_api.repository.entity.QuizAttempt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizAttemptRepository extends JpaRepository<QuizAttempt, Long> {
}