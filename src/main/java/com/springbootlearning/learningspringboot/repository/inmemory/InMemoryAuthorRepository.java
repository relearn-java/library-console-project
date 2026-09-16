package com.springbootlearning.learningspringboot.repository.inmemory;



import com.springbootlearning.learningspringboot.domain.Author;
import com.springbootlearning.learningspringboot.repository.AuthorRepository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

public class InMemoryAuthorRepository implements AuthorRepository {

    private final Map<Long, Author> storage = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    @Override
    public Author save(Author author) {
        Long id = author.id();
        if (id == null) {
            id = idGenerator.getAndIncrement();
            author = new Author(id, author.name());
        }
        storage.put(id, author);
        return author;
    }

    @Override
    public Optional<Author> findById(Long id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public List<Author> findAll() {
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
    public List<Author> findByName(String name) {
        return storage.values().stream()
                .filter(a -> a.name().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }
}