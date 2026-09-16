package com.springbootlearning.learningspringboot.repository.inmemory;

import com.springbootlearning.learningspringboot.domain.AuditLog;
import com.springbootlearning.learningspringboot.repository.AuditLogRepository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

public class InMemoryAuditLogRepository implements AuditLogRepository {

    private final Map<Long, AuditLog> storage = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    @Override
    public AuditLog save(AuditLog log) {
        Long id = log.id();
        if (id == null) {
            id = idGenerator.getAndIncrement();
            log = new AuditLog(id, log.userId(), log.action(),
                    log.tableName(), log.recordId(),
                    log.oldValue(), log.newValue(), log.createdAt());
        }
        storage.put(id, log);
        return log;
    }

    @Override
    public Optional<AuditLog> findById(Long id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public List<AuditLog> findAll() {
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
    public List<AuditLog> findByUserId(Long userId) {
        return storage.values().stream()
                .filter(l -> Objects.equals(l.userId(), userId))
                .collect(Collectors.toList());
    }

    @Override
    public List<AuditLog> findByTableName(String tableName) {
        return storage.values().stream()
                .filter(l -> l.tableName().equalsIgnoreCase(tableName))
                .collect(Collectors.toList());
    }

    @Override
    public List<AuditLog> findByRecordId(Long recordId) {
        return storage.values().stream()
                .filter(l -> Objects.equals(l.recordId(), recordId))
                .collect(Collectors.toList());
    }
}