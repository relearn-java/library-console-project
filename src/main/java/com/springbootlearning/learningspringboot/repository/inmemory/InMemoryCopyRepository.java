package com.springbootlearning.learningspringboot.repository.inmemory;



import com.springbootlearning.learningspringboot.domain.Copy;
import com.springbootlearning.learningspringboot.domain.CopyState;
import com.springbootlearning.learningspringboot.repository.CopyRepository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

public class InMemoryCopyRepository implements CopyRepository {

    private final Map<Long, Copy> storage = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    @Override
    public Copy save(Copy copy) {
        Long id = copy.id();
        if (id == null) {
            id = idGenerator.getAndIncrement();
            copy = new Copy(id, copy.bookId(), copy.state());
        }
        storage.put(id, copy);
        return copy;
    }

    @Override
    public Optional<Copy> findById(Long id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public List<Copy> findAll() {
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
    public List<Copy> findByBookId(Long bookId) {
        return storage.values().stream()
                .filter(c -> Objects.equals(c.bookId(), bookId))
                .collect(Collectors.toList());
    }

    @Override
    public List<Copy> findByState(CopyState state) {
        return storage.values().stream()
                .filter(c -> c.state() == state)
                .collect(Collectors.toList());
    }
}
