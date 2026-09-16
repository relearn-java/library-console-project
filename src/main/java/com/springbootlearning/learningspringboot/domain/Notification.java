package com.springbootlearning.learningspringboot.domain;

import java.time.LocalDateTime;

public record Notification(
        Long id,
        Long userId,
        String message,
        boolean isRead,
        LocalDateTime createdAt
) {}
