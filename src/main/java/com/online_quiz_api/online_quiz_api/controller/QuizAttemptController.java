package com.online_quiz_api.online_quiz_api.controller;


import com.online_quiz_api.online_quiz_api.Service.QuizAttemptService;
import com.online_quiz_api.online_quiz_api.repository.entity.QuizAttempt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("quiz/{quizId}/quiz_attempts")
public class QuizAttemptController {
    @Autowired
    private QuizAttemptService quizAttemptService;

    @GetMapping
    public List<QuizAttempt> getAllQuizAttempts(@PathVariable Long quizId) {
        return quizAttemptService.getAllQuizAttempts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuizAttempt> getQuizAttemptById(@PathVariable Long quizId, @PathVariable Long id) {
        QuizAttempt quizAttempt = quizAttemptService.getQuizAttemptById(id);
        if (quizAttempt != null) {
            return ResponseEntity.ok(quizAttempt);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public QuizAttempt createQuizAttempt(@PathVariable Long quizId, @RequestBody QuizAttempt quizAttempt) {
        return quizAttemptService.createQuizAttempt(quizId, quizAttempt);
    }

    @PutMapping("/{id}")
    public ResponseEntity<QuizAttempt> updateQuizAttempt(@PathVariable Long quizId, @PathVariable Long id, @RequestBody QuizAttempt quizAttempt) {
        QuizAttempt updatedQuizAttempt = quizAttemptService.updateQuizAttempt(quizId, id, quizAttempt);
        if (updatedQuizAttempt != null) {
            return ResponseEntity.ok(updatedQuizAttempt);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuizAttempt(@PathVariable Long quizId, @PathVariable Long id) {
        quizAttemptService.deleteQuizAttempt(id);
        return ResponseEntity.noContent().build();
    }
}