package com.springbootlearning.learningspringboot.repository;

import com.springbootlearning.learningspringboot.domain.Author;

import java.util.List;

public interface AuthorRepository extends Repository<Author, Long> {
    List<Author> findByName(String name);
}