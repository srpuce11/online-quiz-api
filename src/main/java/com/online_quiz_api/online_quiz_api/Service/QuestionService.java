package com.online_quiz_api.online_quiz_api.Service;


import com.online_quiz_api.online_quiz_api.repository.QuestionRepository;
import com.online_quiz_api.online_quiz_api.repository.entity.Question;
import com.online_quiz_api.online_quiz_api.repository.entity.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    public Question getQuestionById(Long quizId, Long id) {
        return questionRepository.findById(id).orElse(null);
    }

    public Question createQuestion(Long quizId, Question question) {

        Quiz quiz = new Quiz();
        quiz.setId(quizId);
        question.setQuiz(quiz);
        return questionRepository.save(question);
    }

    public Question updateQuestion(Long quizId, Long id, Question question) {
        Question existingQuestion = questionRepository.findById(id).orElse(null);

        Quiz quiz = new Quiz();
        quiz.setId(quizId);

        if (existingQuestion != null) {
            existingQuestion.setQuiz(quiz);
            existingQuestion.setQuestionText(question.getQuestionText());
            return questionRepository.save(existingQuestion);
        }
        return null;
    }

    public void deleteQuestion(Long id) {
        questionRepository.deleteById(id);
    }
}
