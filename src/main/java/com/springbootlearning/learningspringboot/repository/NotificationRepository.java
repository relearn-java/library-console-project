package com.springbootlearning.learningspringboot.repository;

import com.springbootlearning.learningspringboot.domain.Notification;

import java.util.List;

public interface NotificationRepository extends Repository<Notification, Long> {
    List<Notification> findByUserId(Long userId);
    List<Notification> findUnreadByUserId(Long userId);
}