package com.ar.booking_service.service;

import com.ar.booking_service.dto.BookingRequestDTO;
import com.ar.booking_service.dto.BookingResponseDTO;
import com.ar.booking_service.entity.BookingEntity;
import com.ar.booking_service.repository.BookingRepository;
import com.ar.booking_service.util.BookingMapper;
import com.ar.logistics_models.options.BookingStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BookingService {
    private final BookingRepository bookingRepository;

    // Save booking
    public BookingResponseDTO createBooking(BookingRequestDTO request) {
        BookingEntity entity = BookingMapper.toEntity(request);
        entity.setBookingId(UUID.randomUUID().toString());
        entity.setStatus(BookingStatus.PENDING);

        BookingEntity saved = bookingRepository.save(entity);
        return BookingMapper.toResponseDTO(saved);
    }

    // Get booking by bookingId
    public BookingResponseDTO getBookingById(String bookingId) {
        BookingEntity entity = bookingRepository.findByBookingId(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found: " + bookingId));
        return BookingMapper.toResponseDTO(entity);
    }
}

