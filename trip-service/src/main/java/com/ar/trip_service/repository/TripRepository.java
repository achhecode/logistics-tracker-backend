package com.ar.trip_service.repository;

import com.ar.trip_service.entity.TripEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TripRepository extends JpaRepository<TripEntity, Long> {
    Optional<TripEntity> findByTripId(String tripId);
    Optional<TripEntity> findByBookingId(String bookingId);
}
