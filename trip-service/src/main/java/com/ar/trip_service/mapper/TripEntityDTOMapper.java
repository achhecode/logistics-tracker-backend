package com.ar.trip_service.mapper;

import com.ar.logistics_models.dto.TripDTO;
import com.ar.logistics_models.dto.TripEventDTO;
import com.ar.trip_service.entity.TripEntity;
import com.ar.trip_service.entity.TripEventEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TripEntityDTOMapper {

    TripDTO toDTO(TripEntity entity);
    TripEntity toEntity(TripDTO dto);

//    @Mapping(source = "trip.tripId", target = "tripId")
    TripEventDTO toDTO(TripEventEntity entity);
    TripEventEntity toEntity(TripEventDTO dto);

    List<TripEventDTO> toDTOs(List<TripEventEntity> entities);
    List<TripEventEntity> toEntities(List<TripEventDTO> dtos);
}
