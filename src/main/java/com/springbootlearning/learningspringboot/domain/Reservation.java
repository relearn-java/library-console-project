package com.springbootlearning.learningspringboot.domain;

import java.time.LocalDateTime;

public record Reservation(
        Long id,
        Long userId,
        Long bookId,
        LocalDateTime reservationDate,
        ReservationStatus status
) {}
