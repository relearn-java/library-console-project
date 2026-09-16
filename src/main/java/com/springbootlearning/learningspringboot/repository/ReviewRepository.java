package com.springbootlearning.learningspringboot.repository;

import com.springbootlearning.learningspringboot.domain.Review;

import java.util.List;

public interface ReviewRepository extends Repository<Review,Long>{
    List<Review> findByBookId(Long bookId);
    List<Review> findByUserId(Long userId);
}
