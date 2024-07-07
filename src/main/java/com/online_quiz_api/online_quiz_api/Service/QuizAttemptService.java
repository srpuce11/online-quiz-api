package com.online_quiz_api.online_quiz_api.Service;

import com.online_quiz_api.online_quiz_api.repository.QuizAttemptRepository;
import com.online_quiz_api.online_quiz_api.repository.entity.Quiz;
import com.online_quiz_api.online_quiz_api.repository.entity.QuizAttempt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizAttemptService {
    @Autowired
    private QuizAttemptRepository quizAttemptRepository;

    public List<QuizAttempt> getAllQuizAttempts() {
        return quizAttemptRepository.findAll();
    }

    public QuizAttempt getQuizAttemptById(Long id) {
        return quizAttemptRepository.findById(id).orElse(null);
    }

    public QuizAttempt createQuizAttempt(Long quizId, QuizAttempt quizAttempt) {

        Quiz quiz = new Quiz();
        quiz.setId(quizId);
        quizAttempt.setQuiz(quiz);

        return quizAttemptRepository.save(quizAttempt);
    }

    public QuizAttempt updateQuizAttempt(Long quizId, Long id, QuizAttempt quizAttempt) {

        Quiz quiz = new Quiz();
        quiz.setId(quizId);
        quizAttempt.setQuiz(quiz);

        QuizAttempt existingQuizAttempt = quizAttemptRepository.findById(id).orElse(null);
        if (existingQuizAttempt != null) {
            existingQuizAttempt.setStudentId(quizAttempt.getStudentId());
            existingQuizAttempt.setScore(quizAttempt.getScore());
            existingQuizAttempt.setAttemptedAt(quizAttempt.getAttemptedAt());
            return quizAttemptRepository.save(existingQuizAttempt);
        }
        return null;
    }

    public void deleteQuizAttempt(Long id) {
        quizAttemptRepository.deleteById(id);
    }
}