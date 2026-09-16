package com.springbootlearning.learningspringboot.domain;

import java.time.LocalDate;

public record Loan(
        Long id,
        Long userId,
        LocalDate startDate,
        LocalDate dueDate,
        LocalDate actualReturnDate
) {
    public boolean isReturned() {
        return actualReturnDate != null;
    }

    public boolean isLate() {
        return !isReturned() && LocalDate.now().isAfter(dueDate);
    }
}
