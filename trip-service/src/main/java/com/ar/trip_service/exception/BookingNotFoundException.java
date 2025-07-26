package com.ar.trip_service.exception;

public class BookingNotFoundException extends RuntimeException{
    public BookingNotFoundException(String bookingId) {
        super("Booking not found for order ID: " + bookingId);
    }
}
