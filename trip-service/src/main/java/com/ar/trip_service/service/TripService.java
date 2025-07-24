package com.ar.trip_service.service;

import com.ar.trip_service.dto.TripDTO;
import com.ar.trip_service.entity.Trip;
import com.ar.trip_service.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TripService {

    @Autowired
    private TripRepository tripRepository;

    public TripDTO createTrip(TripDTO dto) {
        Trip trip = new Trip();
        trip.setOrigin(dto.getOrigin());
        trip.setDestination(dto.getDestination());
        trip.setWeight(dto.getWeight());
        trip.setVehicleNumber(dto.getVehicleNumber());
        trip.setStartDate(dto.getStartDate());
        trip.setEndDate(dto.getEndDate());
        trip.setStatus(dto.getStatus());

        Trip saved = tripRepository.save(trip);

        dto.setId(saved.getId());
        return dto;
    }

    public TripDTO getTripById(Long id) {
        Optional<Trip> tripOpt = tripRepository.findById(id);
        if (tripOpt.isEmpty()) throw new RuntimeException("Trip not found");

        Trip trip = tripOpt.get();
        return new TripDTO(
                trip.getId(),
                trip.getOrigin(),
                trip.getDestination(),
                trip.getWeight(),
                trip.getVehicleNumber(),
                trip.getStartDate(),
                trip.getEndDate(),
                trip.getStatus()
        );
    }
}
