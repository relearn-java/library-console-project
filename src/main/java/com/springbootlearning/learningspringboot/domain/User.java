package com.springbootlearning.learningspringboot.domain;

import java.time.LocalDate;

public record User(
        Long id,
        String lastName,
        String firstName,
        String email,
        String phone,
        String address,
        LocalDate registrationDate,
        String password,
        UserStatus status,
        Role role
) {}
