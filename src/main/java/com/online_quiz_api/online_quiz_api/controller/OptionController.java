package com.online_quiz_api.online_quiz_api.controller;


import com.online_quiz_api.online_quiz_api.Service.OptionService;
import com.online_quiz_api.online_quiz_api.repository.entity.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/quiz/{quizId}/question/{questionId}/options")
public class OptionController {
    @Autowired
    private OptionService optionService;

    @GetMapping
    public List<Option> getAllOptions(@PathVariable Long quizId, @PathVariable Long questionId) {
        return optionService.getAllOptions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Option>> getOptionByQuestionAndId(@PathVariable Long quizId, @PathVariable Long questionId, @PathVariable Long id) {
        List<Option> option = optionService.getOptionByQuestionIdAndId(questionId, id);
        if (option != null) {
            return ResponseEntity.ok(option);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Option createOption(@PathVariable Long quizId, @PathVariable Long questionId, @RequestBody Option option) {
        return optionService.createOption(questionId, option);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Option> updateOption(@PathVariable Long quizId, @PathVariable Long questionId, @PathVariable Long id, @RequestBody Option option) {
        Option updatedOption = optionService.updateOption(questionId, id, option);
        if (updatedOption != null) {
            return ResponseEntity.ok(updatedOption);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOption(@PathVariable Long quizId, @PathVariable Long questionId, @PathVariable Long id) {
        optionService.deleteOption(id);
        return ResponseEntity.noContent().build();
    }
}