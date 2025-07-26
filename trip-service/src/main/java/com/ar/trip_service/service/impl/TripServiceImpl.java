package com.ar.trip_service.service.impl;

import com.ar.logistics_models.dto.BookingDTO;
import com.ar.logistics_models.dto.TripDTO;
import com.ar.logistics_models.dto.TripEventDTO;
import com.ar.logistics_models.options.EventType;
import com.ar.logistics_models.options.TripStatus;
import com.ar.trip_service.entity.TripEntity;
import com.ar.trip_service.entity.TripEventEntity;
import com.ar.trip_service.exception.TripAlreadyExistsException;
import com.ar.trip_service.mapper.TripEntityDTOMapper;
import com.ar.trip_service.mapper.TripEntityToDTOMapper;
import com.ar.trip_service.mapper.TripMapper;
import com.ar.trip_service.repository.TripEventRepository;
import com.ar.trip_service.repository.TripRepository;
import com.ar.trip_service.service.TripService;
import com.ar.trip_service.util.HexIdGenerator;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
@Slf4j
public class TripServiceImpl implements TripService {

    @Autowired
    private TripRepository tripRepository;

    private final TripEventRepository tripEventRepository;
    private final TripEntityDTOMapper tripEntityDTOMapper;

    @Autowired
    private TripEntityToDTOMapper tripEntityToDTOMapper;

    @Override
    @Transactional
    public TripDTO createTrip(BookingDTO bookingDTO) {
        // find by booking id, if exists not create another trip for same order
        if (tripRepository.findByBookingId(bookingDTO.getBookingId()).isPresent()) {
            throw new TripAlreadyExistsException(bookingDTO.getBookingId());
        }

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
    public TripEventDTO logEvent(TripEventDTO eventDTO) {
        TripEntity trip = tripRepository.findByTripId(eventDTO.getTripId())
                .orElseThrow(() -> new RuntimeException("Trip not found for tripId " + eventDTO.getTripId()));

        // if delivered
        if(eventDTO.getEventType().equals(EventType.DELIVERY)){
            trip.setStatus(TripStatus.COMPLETED);
            tripRepository.save(trip);
        }

        TripEventEntity event = tripEntityDTOMapper.toEntity(eventDTO);
        event.setTimestamp(Instant.now());
        event.setTrip(trip);

        trip.getEvents().add(event); // ensures consistency in bidirectional mapping

        TripEventEntity saved = tripEventRepository.save(event);
        return tripEntityToDTOMapper.toDTO(saved);
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
