package com.ar.trip_service.service.impl;

import com.ar.logistics_models.dto.BookingDTO;
import com.ar.logistics_models.dto.TripDTO;
import com.ar.logistics_models.dto.TripEventDTO;
import com.ar.logistics_models.options.TripStatus;
import com.ar.trip_service.entity.TripEntity;
import com.ar.trip_service.entity.TripEventEntity;
import com.ar.trip_service.mapper.TripEntityDTOMapper;
import com.ar.trip_service.mapper.TripMapper;
import com.ar.trip_service.repository.TripEventRepository;
import com.ar.trip_service.repository.TripRepository;
import com.ar.trip_service.service.TripService;
import com.ar.trip_service.util.HexIdGenerator;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
@Slf4j
public class TripServiceImpl implements TripService {

    private final TripRepository tripRepository;
    private final TripEventRepository tripEventRepository;
    private final TripEntityDTOMapper tripEntityDTOMapper;

    @Override
    @Transactional
    public TripDTO createTrip(BookingDTO bookingDTO) {
        TripEntity entity = TripMapper.toEntity(bookingDTO);
        entity.setTripId(HexIdGenerator.generateHexId());
        entity.setVehicleId(HexIdGenerator.generateVehicleId());
        entity.setDriverId(HexIdGenerator.generateDriverId());
        entity.setStatus(TripStatus.IN_PROGRESS);
        TripEntity saved = tripRepository.save(entity);
        return tripEntityDTOMapper.toDTO(saved);
    }

    @Override
    public TripDTO getTripById(Long id) {
        TripEntity entity = tripRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Trip not found with id " + id));
        return tripEntityDTOMapper.toDTO(entity);
    }

    @Override
    public TripDTO getTripByTripId(String tripId) {
        TripEntity entity = tripRepository.findByTripId(tripId)
                .orElseThrow(() -> new RuntimeException("Trip not found with id " + tripId));
        return tripEntityDTOMapper.toDTO(entity);
    }


    @Override
    @Transactional
    public TripEventDTO logEvent(String tripId, TripEventDTO eventDTO) {
        TripEntity trip = tripRepository.findByTripId(tripId)
                .orElseThrow(() -> new RuntimeException("Trip not found for bookingId " + tripId));

        TripEventEntity event = tripEntityDTOMapper.toEntity(eventDTO);
        event.setTrip(trip);
        event.setTimestamp(Instant.now());

        TripEventEntity saved = tripEventRepository.save(event);
        return tripEntityDTOMapper.toDTO(saved);
    }

    @Override
    @Transactional
    public TripDTO updateTripStatus(String tripId, TripStatus newStatus) {
        TripEntity trip = tripRepository.findByTripId(tripId)
                .orElseThrow(() -> new RuntimeException("Trip not found for bookingId " + tripId));

        trip.setStatus(newStatus);
        TripEntity updated = tripRepository.save(trip);

        return tripEntityDTOMapper.toDTO(updated);
    }

}
