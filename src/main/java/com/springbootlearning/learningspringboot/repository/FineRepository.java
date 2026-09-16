package com.springbootlearning.learningspringboot.repository;


import com.springbootlearning.learningspringboot.domain.Fine;

import java.util.List;

public interface FineRepository extends Repository<Fine, Long> {
    List<Fine> findByLoanId(Long loanId);
    List<Fine> findUnpaidFines();
}