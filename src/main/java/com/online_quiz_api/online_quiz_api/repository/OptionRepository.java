package com.online_quiz_api.online_quiz_api.repository;

import com.online_quiz_api.online_quiz_api.repository.entity.Option;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OptionRepository extends JpaRepository<Option, Long> {
    List<Option> findByQuestionIdAndId(Long questionId, Long id);
}