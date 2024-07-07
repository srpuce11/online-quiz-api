package com.online_quiz_api.online_quiz_api.controller;


import com.online_quiz_api.online_quiz_api.Service.QuestionService;
import com.online_quiz_api.online_quiz_api.repository.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/quiz/{quizId}/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @GetMapping
    public List<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Question> getQuestionById(@PathVariable Long quizId, @PathVariable Long id) {
        Question question = questionService.getQuestionById(quizId, id);
        if (question != null) {
            return ResponseEntity.ok(question);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Question createQuestion(@PathVariable Long quizId, @RequestBody Question question) {
        return questionService.createQuestion(quizId, question);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Question> updateQuestion(@PathVariable Long quizId, @PathVariable Long id, @RequestBody Question question) {
        Question updatedQuestion = questionService.updateQuestion(quizId, id, question);
        if (updatedQuestion != null) {
            return ResponseEntity.ok(updatedQuestion);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuestion(@PathVariable Long quizId, @PathVariable Long id) {
        questionService.deleteQuestion(id);
        return ResponseEntity.noContent().build();
    }
}