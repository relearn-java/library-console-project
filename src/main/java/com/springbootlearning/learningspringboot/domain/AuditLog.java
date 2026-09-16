package com.springbootlearning.learningspringboot.domain;

import java.time.LocalDateTime;

public record AuditLog(
        Long id,
        Long userId,
        String action,
        String tableName,
        Long recordId,
        String oldValue,
        String newValue,
        LocalDateTime createdAt
) {}
