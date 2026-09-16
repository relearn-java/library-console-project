package com.springbootlearning.learningspringboot.repository.inmemory;

import com.springbootlearning.learningspringboot.domain.Book;
import com.springbootlearning.learningspringboot.repository.BookRepository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

public class InMemoryBookRepository implements BookRepository {
    private final Map<Long, Book> storage = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    @Override
    public Book save(Book book) {
        Long id = book.id();
        if (id == null) {
            id = idGenerator.getAndIncrement();
            book = new Book(id, book.isbn(), book.title(),
                    book.publisher(), book.publicationYear(),
                    book.categoryId());
        }
        storage.put(id, book);
        return book;
    }

    @Override
    public Optional<Book> findById(Long id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public List<Book> findAll() {
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
    public List<Book> findByTitle(String title) {
        return storage.values().stream()
                .filter(b -> b.title().toLowerCase().contains(title.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> findByAuthorId(Long authorId) {
        // Sera implémenté quand on aura la table author_book
        return List.of();
    }

    @Override
    public List<Book> findByCategoryId(Long categoryId) {
        return storage.values().stream()
                .filter(b -> Objects.equals(b.categoryId(), categoryId))
                .collect(Collectors.toList());
    }
}
