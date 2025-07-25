package com.ar.booking_service.controller;

import com.ar.booking_service.dto.BookingRequestDTO;
import com.ar.booking_service.dto.BookingResponseDTO;
import com.ar.booking_service.service.BookingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping
    public ResponseEntity<BookingResponseDTO> createBooking(@RequestBody BookingRequestDTO request) {
        BookingResponseDTO response = bookingService.createBooking(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{bookingId}")
    public ResponseEntity<BookingResponseDTO> getBooking(@PathVariable String bookingId) {
        BookingResponseDTO response = bookingService.getBookingById(bookingId);
        return ResponseEntity.ok(response);
    }
}
