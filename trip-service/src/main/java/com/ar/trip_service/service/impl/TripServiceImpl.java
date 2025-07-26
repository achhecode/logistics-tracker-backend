package com.ar.trip_service.service.impl;

import com.ar.logistics_models.dto.TripDTO;
import com.ar.logistics_models.dto.TripEventDTO;
import com.ar.logistics_models.options.EventType;
import com.ar.logistics_models.options.TripStatus;
import com.ar.trip_service.client.BookingServiceClient;
import com.ar.trip_service.dto.TripRequest;
import com.ar.trip_service.entity.TripEntity;
import com.ar.trip_service.entity.TripEventEntity;
import com.ar.trip_service.exception.BookingNotFoundException;
import com.ar.trip_service.exception.TripAlreadyExistsException;
import com.ar.trip_service.mapper.TripEntityDTOMapper;
import com.ar.trip_service.mapper.TripEntityToDTOMapper;
import com.ar.trip_service.repository.TripEventRepository;
import com.ar.trip_service.repository.TripRepository;
import com.ar.trip_service.service.TripService;
import com.ar.trip_service.util.HexIdGenerator;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TripServiceImpl implements TripService {

    private final TripRepository tripRepository;
    private final TripEventRepository tripEventRepository;
    private final TripEntityDTOMapper tripEntityDTOMapper;
    private final TripEntityToDTOMapper tripEntityToDTOMapper;
    private final BookingServiceClient bookingServiceClient;

    @Override
    @Transactional
    public TripDTO createTrip(TripRequest tripRequest) {
        log.info("Creating trip for tracking id {}", tripRequest.getTrackingId());

        // Check booking existence
        if (!bookingServiceClient.bookingExists(tripRequest.getTrackingId())) {
            log.warn("Booking ID {} does not exist", tripRequest.getTrackingId());
            throw new BookingNotFoundException(tripRequest.getTrackingId());
        }

        // if booking id exists check if trip not created for the order
        if (tripRepository.findByBookingId(tripRequest.getTrackingId()).isPresent()) {
            throw new TripAlreadyExistsException(tripRequest.getTrackingId());
        }

        // Create new TripEntity
        TripEntity entity = TripEntity.builder()
                .tripId(HexIdGenerator.generateHexId())
                .bookingId(tripRequest.getTrackingId())
                .vehicleId(HexIdGenerator.generateVehicleId())
                .driverId(HexIdGenerator.generateDriverId())
                .status(TripStatus.IN_PROGRESS)
                .eta(LocalDate.now().plusDays(7))
                .timestamp(Instant.now())
                .createdAt(LocalDateTime.now())
                .build();

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

        if (eventDTO.getEventType() == EventType.DELIVERY) {
            trip.setStatus(TripStatus.COMPLETED);
            tripRepository.save(trip);
        }

        TripEventEntity event = tripEntityDTOMapper.toEntity(eventDTO);
        event.setTimestamp(Instant.now());
        event.setTrip(trip);
        trip.getEvents().add(event); // Maintain bidirectional consistency

        TripEventEntity saved = tripEventRepository.save(event);
        return tripEntityToDTOMapper.toDTO(saved);
    }

    @Override
    @Transactional
    public TripEventDTO logEvents(List<TripEventDTO> eventDTOs) {
        return null;
        // TODO add bulk events feature
    }

    @Override
    public List<TripEventDTO> getEvents() {
        List<TripEventEntity> events = tripEventRepository.findAll();
        return events.stream()
                .map(tripEntityToDTOMapper::toDTO)
                .toList();
    }

    @Override
    public TripEventDTO getEventById(String id) {
        Long eventId;
        try {
            eventId = Long.parseLong(id);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid event ID: " + id);
        }

        TripEventEntity event = tripEventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found with id: " + id));

        return tripEntityToDTOMapper.toDTO(event);
    }

    @Override
    public List<TripEventDTO> getEventByTripId(String tripId) {
        List<TripEventEntity> events = tripEventRepository.findByTrip_TripId(tripId);

        if (events.isEmpty()) {
            throw new RuntimeException("No events found for tripId: " + tripId);
        }

        return events.stream()
                .map(tripEntityToDTOMapper::toDTO)
                .toList();
    }


    @Override
    @Transactional
    public TripDTO updateTripStatus(String tripId, TripStatus newStatus) {
        TripEntity trip = tripRepository.findByTripId(tripId)
                .orElseThrow(() -> new RuntimeException("Trip not found for tripId " + tripId));

        trip.setStatus(newStatus);
        TripEntity updated = tripRepository.save(trip);

        return tripEntityDTOMapper.toDTO(updated);
    }
}
