package com.ar.trip_service.entity;

import com.ar.trip_service.model.TripStatus;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Data
public class Trip {
    @Id
    @GeneratedValue
    private Long id;

    private String origin;
    private String destination;
    private LocalDate startDate;
    private LocalDate expectedDeliveryDate;
    private LocalDate actualDeliveryDate;
    private double weight;
    private String vehicleNumber;

    @Enumerated(EnumType.STRING)
    private TripStatus status;

    private LocalDate endDate;
    private Long consigneeId;
    private Long brokerId;

    @ManyToOne
    private Driver driver;
}