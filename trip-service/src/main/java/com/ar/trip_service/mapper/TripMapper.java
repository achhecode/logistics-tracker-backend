package com.ar.trip_service.mapper;

import com.ar.logistics_models.dto.BookingDTO;
import com.ar.trip_service.entity.TripEntity;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class TripMapper {
    public static TripEntity toEntity(BookingDTO bookingDTO) {
        return TripEntity.builder()
                .id(null) // generated in service
                .tripId(null)
                .bookingId(bookingDTO.getBookingId())
                .vehicleId(null) // generated in service
                .driverId(null) // generated in service
                .status(null)
                .eta(LocalDate.now().plusDays(7))
                .timestamp(Instant.now())
                .createdAt(LocalDateTime.now())
                .events(null)
                .build();
    }
//  Not needed
//    public static BookingDTO toBookingDTO(TripEntity tripEntity) {
//    }
}
