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

    @PostMapping("/events")
    public ResponseEntity<TripEventDTO> logTripEvent(
            @RequestBody TripEventDTO eventDTO
    ) {
        return ResponseEntity.ok(tripService.logEvent(eventDTO));
    }

    @PutMapping("/{tripId}/status")
    public ResponseEntity<TripDTO> updateTripStatus(
            @PathVariable String tripId,
            @RequestParam TripStatus status
    ) {
        return ResponseEntity.ok(tripService.updateTripStatus(tripId, status));
    }

}