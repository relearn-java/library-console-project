package com.springbootlearning.learningspringboot.repository;

import com.springbootlearning.learningspringboot.domain.Book;

import java.util.List;

public interface BookRepository extends Repository<Book,Long>{
    List<Book> findByTitle(String title);
    List<Book> findByAuthorId(Long authorId);
    List<Book> findByCategoryId(Long categoryId);
}
