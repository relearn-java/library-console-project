package com.springbootlearning.learningspringboot.repository.inmemory;

import com.springbootlearning.learningspringboot.domain.Notification;
import com.springbootlearning.learningspringboot.repository.NotificationRepository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

public class InMemoryNotificationRepository implements NotificationRepository {

    private final Map<Long, Notification> storage = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    @Override
    public Notification save(Notification notification) {
        Long id = notification.id();
        if (id == null) {
            id = idGenerator.getAndIncrement();
            notification = new Notification(id, notification.userId(),
                    notification.message(), notification.isRead(),
                    notification.createdAt());
        }
        storage.put(id, notification);
        return notification;
    }

    @Override
    public Optional<Notification> findById(Long id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public List<Notification> findAll() {
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
    public List<Notification> findByUserId(Long userId) {
        return storage.values().stream()
                .filter(n -> Objects.equals(n.userId(), userId))
                .collect(Collectors.toList());
    }

    @Override
    public List<Notification> findUnreadByUserId(Long userId) {
        return storage.values().stream()
                .filter(n -> Objects.equals(n.userId(), userId) && !n.isRead())
                .collect(Collectors.toList());
    }
}