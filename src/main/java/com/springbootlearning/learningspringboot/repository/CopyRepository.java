package com.springbootlearning.learningspringboot.repository;

import com.springbootlearning.learningspringboot.domain.Copy;
import com.springbootlearning.learningspringboot.domain.CopyState;

import java.util.List;

public interface CopyRepository extends Repository<Copy,Long>{
    List<Copy> findByBookId(Long bookId);
    List<Copy> findByState(CopyState state);
}
