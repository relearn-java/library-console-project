package com.springbootlearning.learningspringboot.repository;

import com.springbootlearning.learningspringboot.domain.AuditLog;

import java.util.List;

public interface AuditLogRepository extends Repository<AuditLog, Long> {
    List<AuditLog> findByUserId(Long userId);
    List<AuditLog> findByTableName(String tableName);
    List<AuditLog> findByRecordId(Long recordId);
}