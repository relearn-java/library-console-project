package com.springbootlearning.learningspringboot.repository.inmemory;


import com.springbootlearning.learningspringboot.domain.Category;
import com.springbootlearning.learningspringboot.repository.CategoryRepository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

public class InMemoryCategoryRepository implements CategoryRepository {

    private final Map<Long, Category> storage = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    @Override
    public Category save(Category category) {
        Long id = category.id();
        if (id == null) {
            id = idGenerator.getAndIncrement();
            category = new Category(id, category.name());
        }
        storage.put(id, category);
        return category;
    }

    @Override
    public Optional<Category> findById(Long id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public List<Category> findAll() {
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
    public List<Category> findByName(String name) {
        return storage.values().stream()
                .filter(c -> c.name().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }
}