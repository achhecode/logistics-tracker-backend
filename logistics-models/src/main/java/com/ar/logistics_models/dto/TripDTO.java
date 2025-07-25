package com.ar.logistics_models.dto;

import com.ar.logistics_models.options.TripStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TripDTO {
    private String tripId;
    private String bookingId;
    private String vehicleId;
    private String driverId;
    private TripStatus status;
    private Instant eta;
    private Instant createdAt;
    private List<TripEventDTO> events;
}
