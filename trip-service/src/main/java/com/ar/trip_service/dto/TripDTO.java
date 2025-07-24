package com.ar.trip_service.dto;

import com.ar.trip_service.model.TripStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TripDTO {
    private Long id;
    private String origin;
    private String destination;
//    private double weight;
//    private String vehicleNumber;
    private LocalDate startDate;
//    private LocalDate endDate;
    private TripStatus status;
}
