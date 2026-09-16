package com.springbootlearning.learningspringboot.repository;

import com.springbootlearning.learningspringboot.domain.Category;

import java.util.List;

public interface CategoryRepository extends Repository<Category, Long> {
    List<Category> findByName(String name);
}
