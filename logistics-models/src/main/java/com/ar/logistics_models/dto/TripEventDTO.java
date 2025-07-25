package com.ar.logistics_models.dto;

import com.ar.logistics_models.options.EventType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TripEventDTO {
    private String tripId;
    private EventType eventType;
    private String location;
    private String description;
    private LocalDateTime timestamp;
    private BigDecimal cost;
}
