package com.ar.trip_service.service;

import com.ar.logistics_models.dto.BookingDTO;
import com.ar.logistics_models.dto.TripDTO;
import com.ar.logistics_models.dto.TripEventDTO;
import com.ar.logistics_models.options.TripStatus;
import com.ar.trip_service.dto.TripRequest;

import java.util.List;

public interface TripService {
    TripDTO createTrip(TripRequest tripRequest);
    List<TripDTO> getTrips();
    TripDTO getTripById(Long id);
    TripDTO getTripByTripId(String tripId);
    TripEventDTO logEvent(TripEventDTO eventDTO);
    TripEventDTO logEvents(List<TripEventDTO> eventDTOs);
    List<TripEventDTO> getEvents();
    TripEventDTO getEventById(String id);
    List<TripEventDTO> getEventByTripId(String tripId);
    TripDTO updateTripStatus(String tripId, TripStatus newStatus);
}
