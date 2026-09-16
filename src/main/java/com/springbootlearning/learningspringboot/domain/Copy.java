package com.springbootlearning.learningspringboot.domain;

public record Copy(
        Long id,
        Long bookId,
        CopyState state) {}
