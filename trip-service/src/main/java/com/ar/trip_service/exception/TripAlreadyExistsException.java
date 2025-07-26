package com.ar.trip_service.exception;

public class TripAlreadyExistsException extends RuntimeException {
    public TripAlreadyExistsException(String bookingId) {
        super("Trip already created for order ID: " + bookingId);
    }
}
