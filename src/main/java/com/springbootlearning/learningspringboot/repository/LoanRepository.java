package com.springbootlearning.learningspringboot.repository;

import com.springbootlearning.learningspringboot.domain.Loan;

import java.util.List;

public interface LoanRepository extends Repository<Loan,Long>{
    List<Loan> findByUserId(Long userId);
    List<Loan> findActiveLoans();
    List<Loan> findLateLoans();
}
