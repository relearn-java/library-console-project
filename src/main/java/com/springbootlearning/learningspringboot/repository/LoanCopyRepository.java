package com.springbootlearning.learningspringboot.repository;

import com.springbootlearning.learningspringboot.domain.LoanCopy;

import java.util.List;

public interface LoanCopyRepository {
    LoanCopy save(LoanCopy loanCopy);
    List<LoanCopy> findByLoanId(Long loanId);
    List<LoanCopy> findByCopyId(Long copyId);
    void deleteByLoanId(Long loanId);
    void deleteByCopyId(Long copyId);
    boolean existsByCopyId(Long copyId);
}
