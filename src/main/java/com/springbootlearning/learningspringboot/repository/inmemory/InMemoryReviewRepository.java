package com.springbootlearning.learningspringboot.repository.inmemory;

import com.springbootlearning.learningspringboot.domain.Review;
import com.springbootlearning.learningspringboot.repository.ReviewRepository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

public class InMemoryReviewRepository implements ReviewRepository {

    private final Map<Long, Review> storage = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    @Override
    public Review save(Review review) {
        Long id = review.id();
        if (id == null) {
            id = idGenerator.getAndIncrement();
            review = new Review(id, review.userId(), review.bookId(),
                    review.rating(), review.comment(), review.createdAt());
        }
        storage.put(id, review);
        return review;
    }

    @Override
    public Optional<Review> findById(Long id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public List<Review> findAll() {
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
    public List<Review> findByBookId(Long bookId) {
        return storage.values().stream()
                .filter(r -> Objects.equals(r.bookId(), bookId))
                .collect(Collectors.toList());
    }

    @Override
    public List<Review> findByUserId(Long userId) {
        return storage.values().stream()
                .filter(r -> Objects.equals(r.userId(), userId))
                .collect(Collectors.toList());
    }
}