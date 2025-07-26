package com.ar.trip_service.controller;

import com.ar.logistics_models.dto.BookingDTO;
import com.ar.logistics_models.dto.TripDTO;
import com.ar.logistics_models.dto.TripEventDTO;
import com.ar.logistics_models.options.TripStatus;
import com.ar.trip_service.dto.TripRequest;
import com.ar.trip_service.service.TripService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/trips")
@Slf4j
public class TripController {
    @Autowired
    private TripService tripService;

    // assign vehicle+driver
    @PostMapping("/add")
    public ResponseEntity<TripDTO> createTrip(@RequestBody TripRequest tripRequest) {
        return ResponseEntity.ok(tripService.createTrip(tripRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TripDTO> getTripById(@PathVariable Long id) {
        return ResponseEntity.ok(tripService.getTripById(id));
    }

    @GetMapping("/track/{tripId}")
    public ResponseEntity<TripDTO> getTripByTripId(@PathVariable String tripId) {
        return ResponseEntity.ok(tripService.getTripByTripId(tripId));
    }

    @PostMapping("/event")
    public ResponseEntity<TripEventDTO> logTripEvent(
            @RequestBody TripEventDTO eventDTO
    ) {
        return ResponseEntity.ok(tripService.logEvent(eventDTO));
    }

    @PostMapping("/events")
    public ResponseEntity<List<TripEventDTO>> logTripEvents(
            @RequestBody List<TripEventDTO> tripEventDTOS
    ) {
//        return ResponseEntity.ok(tripService.logEvents(tripEventDTOS));
        return null;
    }

    @GetMapping("/events")
    public ResponseEntity<List<TripEventDTO>> getAllEvents() {
        return ResponseEntity.ok(tripService.getEvents());
    }

    @GetMapping("/events/id/{id}")
    public ResponseEntity<TripEventDTO> getEventById(@PathVariable String id) {
        return ResponseEntity.ok(tripService.getEventById(id));
    }

    @GetMapping("/events/{tripId}")
    public ResponseEntity<List<TripEventDTO>> getEventByTripId(@PathVariable String tripId) {
        return ResponseEntity.ok(tripService.getEventByTripId(tripId));
    }

    @PutMapping("/{tripId}/status")
    public ResponseEntity<TripDTO> updateTripStatus(
            @PathVariable String tripId,
            @RequestParam TripStatus status
    ) {
        return ResponseEntity.ok(tripService.updateTripStatus(tripId, status));
    }

}