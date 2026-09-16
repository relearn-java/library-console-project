package com.springbootlearning.learningspringboot.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record Fine(
        Long id,
        Long loanId,
        BigDecimal amount,
        boolean isPaid,
        LocalDateTime createdAt
) {}
