package com.springbootlearning.learningspringboot.repository.inmemory;

import com.springbootlearning.learningspringboot.domain.Fine;
import com.springbootlearning.learningspringboot.repository.FineRepository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

public class InMemoryFineRepository implements FineRepository {

    private final Map<Long, Fine> storage = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    @Override
    public Fine save(Fine fine) {
        Long id = fine.id();
        if (id == null) {
            id = idGenerator.getAndIncrement();
            fine = new Fine(id, fine.loanId(), fine.amount(),
                    fine.isPaid(), fine.createdAt());
        }
        storage.put(id, fine);
        return fine;
    }

    @Override
    public Optional<Fine> findById(Long id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public List<Fine> findAll() {
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
    public List<Fine> findByLoanId(Long loanId) {
        return storage.values().stream()
                .filter(f -> Objects.equals(f.loanId(), loanId))
                .collect(Collectors.toList());
    }

    @Override
    public List<Fine> findUnpaidFines() {
        return storage.values().stream()
                .filter(f -> !f.isPaid())
                .collect(Collectors.toList());
    }
}