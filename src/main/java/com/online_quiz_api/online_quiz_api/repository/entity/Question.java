package com.online_quiz_api.online_quiz_api.repository.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Question {
    @Column(name = "created_at", updatable = false)
    private final LocalDateTime createdAt = LocalDateTime.now();
    @Column(name = "updated_at")
    private final LocalDateTime updatedAt = LocalDateTime.now();
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "quiz_id", nullable = false)
    private Quiz quiz;

    @NotBlank
    @NotNull
    @Column(name = "question_text")
    private String questionText;
}