package com.springbootlearning.learningspringboot.repository.inmemory;

import com.springbootlearning.learningspringboot.domain.LoanCopy;
import com.springbootlearning.learningspringboot.repository.LoanCopyRepository;

import java.util.*;
import java.util.stream.Collectors;

public class InMemoryLoanCopyRepository implements LoanCopyRepository {

    private final List<LoanCopy> storage = new ArrayList<>();

    @Override
    public LoanCopy save(LoanCopy loanCopy) {
        storage.add(loanCopy);
        return loanCopy;
    }

    @Override
    public List<LoanCopy> findByLoanId(Long loanId) {
        return storage.stream()
                .filter(lc -> Objects.equals(lc.loanId(), loanId))
                .collect(Collectors.toList());
    }

    @Override
    public List<LoanCopy> findByCopyId(Long copyId) {
        return storage.stream()
                .filter(lc -> Objects.equals(lc.copyId(), copyId))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteByLoanId(Long loanId) {
        storage.removeIf(lc -> Objects.equals(lc.loanId(), loanId));
    }

    @Override
    public void deleteByCopyId(Long copyId) {
        storage.removeIf(lc -> Objects.equals(lc.copyId(), copyId));
    }

    @Override
    public boolean existsByCopyId(Long copyId) {
        return storage.stream()
                .anyMatch(lc -> Objects.equals(lc.copyId(), copyId));
    }
}
