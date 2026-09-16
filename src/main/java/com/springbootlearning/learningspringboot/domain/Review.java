package com.springbootlearning.learningspringboot.domain;

import java.time.LocalDateTime;

public record Review(
        Long id,
        Long userId,
        Long bookId,
        Integer rating,
        String comment,
        LocalDateTime createdAt
) {}
