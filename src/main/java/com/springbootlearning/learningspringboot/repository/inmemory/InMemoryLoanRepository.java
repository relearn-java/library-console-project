package com.springbootlearning.learningspringboot.repository.inmemory;

import com.springbootlearning.learningspringboot.domain.Loan;
import com.springbootlearning.learningspringboot.repository.LoanRepository;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

public class InMemoryLoanRepository implements LoanRepository {

    private final Map<Long, Loan> storage = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    @Override
    public Loan save(Loan loan) {
        Long id = loan.id();
        if (id == null) {
            id = idGenerator.getAndIncrement();
            loan = new Loan(id, loan.userId(), loan.startDate(),
                    loan.dueDate(), loan.actualReturnDate());
        }
        storage.put(id, loan);
        return loan;
    }

    @Override
    public Optional<Loan> findById(Long id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public List<Loan> findAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public void deleteById(Long id) {
        storage.remove(id);
    }

    @Override
    public boolean existsById(Long id) {
        return storage.containsKey(id);
    }

    @Override
    public List<Loan> findByUserId(Long userId) {
        return storage.values().stream()
                .filter(l -> Objects.equals(l.userId(), userId))
                .collect(Collectors.toList());
    }

    @Override
    public List<Loan> findActiveLoans() {
        return storage.values().stream()
                .filter(l -> l.actualReturnDate() == null)
                .collect(Collectors.toList());
    }

    @Override
    public List<Loan> findLateLoans() {
        LocalDate today = LocalDate.now();
        return storage.values().stream()
                .filter(l -> l.actualReturnDate() == null && today.isAfter(l.dueDate()))
                .collect(Collectors.toList());
    }
}