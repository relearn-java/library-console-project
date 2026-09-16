package com.springbootlearning.learningspringboot.domain;

public record Book(
        Long id,
        String isbn,
        String title,
        String publisher,
        Integer publicationYear,
        Long categoryId
) {}
