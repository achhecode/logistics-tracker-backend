package com.ar.logistics_models.dto;

import com.ar.logistics_models.options.EventType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TripEventDTO {
    private EventType eventType;
    private String location;
    private LocalDateTime timestamp;
    private double cost;
}
