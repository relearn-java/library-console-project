package com.springbootlearning.learningspringboot.repository.inmemory;



import com.springbootlearning.learningspringboot.domain.Reservation;
import com.springbootlearning.learningspringboot.domain.ReservationStatus;
import com.springbootlearning.learningspringboot.repository.ReservationRepository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

public class InMemoryReservationRepository implements ReservationRepository {

    private final Map<Long, Reservation> storage = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    @Override
    public Reservation save(Reservation reservation) {
        Long id = reservation.id();
        if (id == null) {
            id = idGenerator.getAndIncrement();
            reservation = new Reservation(id, reservation.userId(),
                    reservation.bookId(), reservation.reservationDate(),
                    reservation.status());
        }
        storage.put(id, reservation);
        return reservation;
    }

    @Override
    public Optional<Reservation> findById(Long id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public List<Reservation> findAll() {
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
    public List<Reservation> findByUserId(Long userId) {
        return storage.values().stream()
                .filter(r -> Objects.equals(r.userId(), userId))
                .collect(Collectors.toList());
    }

    @Override
    public List<Reservation> findByBookId(Long bookId) {
        return storage.values().stream()
                .filter(r -> Objects.equals(r.bookId(), bookId))
                .collect(Collectors.toList());
    }

    @Override
    public List<Reservation> findByStatus(ReservationStatus status) {
        return storage.values().stream()
                .filter(r -> r.status() == status)
                .collect(Collectors.toList());
    }
}