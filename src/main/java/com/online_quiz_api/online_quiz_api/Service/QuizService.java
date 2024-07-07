package com.online_quiz_api.online_quiz_api.Service;

import com.online_quiz_api.online_quiz_api.repository.QuizRepository;
import com.online_quiz_api.online_quiz_api.repository.entity.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {
    @Autowired
    private QuizRepository quizRepository;

    public List<Quiz> getAllQuizzes() {
        return quizRepository.findAll();
    }

    public Quiz getQuizById(Long id) {
        return quizRepository.findById(id).orElse(null);
    }

    public Quiz createQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    public Quiz updateQuiz(Long id, Quiz quiz) {
        Quiz existingQuiz = quizRepository.findById(id).orElse(null);
        if (existingQuiz != null) {
            existingQuiz.setTitle(quiz.getTitle());
            existingQuiz.setPrice(quiz.getPrice());
            existingQuiz.setUpdatedAt(quiz.getUpdatedAt());
            return quizRepository.save(existingQuiz);
        }
        return null;
    }

    public void deleteQuiz(Long id) {
        quizRepository.deleteById(id);
    }

    public List<Quiz> getQuizByTeacherId(int teacherId) {

        return quizRepository.getQuizByTeacherId(teacherId);
    }
}