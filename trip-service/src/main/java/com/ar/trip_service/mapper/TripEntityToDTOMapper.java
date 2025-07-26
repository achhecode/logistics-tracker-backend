package com.ar.trip_service.mapper;

import com.ar.logistics_models.dto.TripEventDTO;
import com.ar.trip_service.entity.TripEventEntity;
import org.springframework.stereotype.Component;

@Component
public class TripEntityToDTOMapper {
    public TripEventDTO toDTO(TripEventEntity entity) {
        return TripEventDTO.builder()
                .tripId(entity.getTrip() != null ? entity.getTrip().getTripId() : null)
                .eventType(entity.getEventType())
                .location(entity.getLocation())
                .description(entity.getDescription())
                .timestamp(entity.getTimestamp())
                .cost(entity.getCost())
                .build();
    }
}
