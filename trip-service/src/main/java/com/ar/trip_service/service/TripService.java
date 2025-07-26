package com.ar.trip_service.service;

import com.ar.logistics_models.dto.BookingDTO;
import com.ar.logistics_models.dto.TripDTO;
import com.ar.logistics_models.dto.TripEventDTO;
import com.ar.logistics_models.options.TripStatus;
import com.ar.trip_service.dto.TripRequest;

public interface TripService {
    TripDTO createTrip(TripRequest tripRequest);
    TripDTO getTripById(Long id);
    TripDTO getTripByTripId(String tripId);
    TripEventDTO logEvent(TripEventDTO eventDTO);
    TripDTO updateTripStatus(String tripId, TripStatus newStatus);
}
