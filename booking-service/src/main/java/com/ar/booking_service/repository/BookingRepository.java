package com.ar.booking_service.repository;

import com.ar.booking_service.entity.BookingEntity;
import com.ar.logistics_models.dto.BookingDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<BookingEntity, Long> {
    Optional<BookingEntity> findByBookingId(String bookingId);
    boolean existsByBookingId(String bookingId);
}

