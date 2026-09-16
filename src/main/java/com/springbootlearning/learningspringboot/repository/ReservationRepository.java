package com.springbootlearning.learningspringboot.repository;

import com.springbootlearning.learningspringboot.domain.Reservation;
import com.springbootlearning.learningspringboot.domain.ReservationStatus;

import java.util.List;

public interface ReservationRepository extends Repository<Reservation,Long>{
    List<Reservation> findByUserId(Long userId);
    List<Reservation> findByBookId(Long bookId);
    List<Reservation> findByStatus(ReservationStatus status);
}
