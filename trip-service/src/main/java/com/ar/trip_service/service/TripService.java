package com.ar.trip_service.service;

import com.ar.logistics_models.dto.BookingDTO;
import com.ar.logistics_models.dto.TripDTO;
import com.ar.logistics_models.dto.TripEventDTO;
import com.ar.logistics_models.options.TripStatus;

public interface TripService {
    TripDTO createTrip(BookingDTO bookingDTO);
    TripDTO getTripById(Long id);
    TripDTO getTripByTripId(String tripId);
    TripEventDTO logEvent(TripEventDTO eventDTO);
    TripDTO updateTripStatus(String tripId, TripStatus newStatus);
}
