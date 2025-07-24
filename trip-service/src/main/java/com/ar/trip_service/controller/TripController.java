package com.ar.trip_service.controller;

import com.ar.trip_service.dto.ShipmentCost;
import com.ar.trip_service.dto.ShipmentDetailsDTO;
import com.ar.trip_service.dto.TripDTO;
import com.ar.trip_service.service.ShipmentCostService;
import com.ar.trip_service.service.TripService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//@CrossOrigin(origins = "*")
@RequestMapping("/**")
@Slf4j
public class TripController {
    @Autowired
    private TripService tripService;

    @PostMapping
    public ResponseEntity<TripDTO> createTrip(@RequestBody TripDTO dto) {
        return ResponseEntity.ok(tripService.createTrip(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TripDTO> getTrip(@PathVariable Long id) {
        return ResponseEntity.ok(tripService.getTripById(id));
    }
}