package com.springbootlearning.learningspringboot.repository.inmemory;

import com.springbootlearning.learningspringboot.domain.User;
import com.springbootlearning.learningspringboot.repository.UserRepository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

import java.util.*;

public class InMemoryUserRepository implements UserRepository {

    private final Map<Long, User> storage = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    @Override
    public User save(User user) {
        Long id = user.id();
        if (id == null) {
            id = idGenerator.getAndIncrement();
            user = new User(id, user.lastName(), user.firstName(),
                    user.email(), user.phone(), user.address(),
                    user.registrationDate(), user.password(),
                    user.status(), user.role());
        }
        storage.put(id, user);
        return user;
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public List<User> findAll() {
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
    public Optional<User> findByEmail(String email) {
        return storage.values().stream()
                .filter(u -> u.email().equalsIgnoreCase(email))
                .findFirst();
    }
}
