package com.online_quiz_api.online_quiz_api.Service;


import com.online_quiz_api.online_quiz_api.repository.OptionRepository;
import com.online_quiz_api.online_quiz_api.repository.entity.Option;
import com.online_quiz_api.online_quiz_api.repository.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OptionService {
    @Autowired
    private OptionRepository optionRepository;

    public List<Option> getAllOptions() {
        return optionRepository.findAll();
    }

    public Option getOptionById(Long id) {
        return optionRepository.findById(id).orElse(null);
    }

    public Option createOption(Long questionId, Option option) {
        Question question = new Question();
        question.setId(questionId);
        option.setQuestion(question);
        return optionRepository.save(option);
    }

    public Option updateOption(Long questionId, Long id, Option option) {
        Option existingOption = optionRepository.findById(id).orElse(null);
        Question question = new Question();
        question.setId(questionId);

        if (existingOption != null) {
            existingOption.setQuestion(question);
            existingOption.setOptionText(option.getOptionText());
            existingOption.setCorrect(option.isCorrect());
            existingOption.setUpdatedAt(option.getUpdatedAt());
            return optionRepository.save(existingOption);
        }
        return null;
    }

    public void deleteOption(Long id) {
        optionRepository.deleteById(id);
    }

    public List<Option> getOptionByQuestionIdAndId(Long questionId, Long id) {

        return optionRepository.findByQuestionIdAndId(questionId, id);
    }
}