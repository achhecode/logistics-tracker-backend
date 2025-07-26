package com.ar.trip_service.entity;

import com.ar.logistics_models.options.TripStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "trips", uniqueConstraints = @UniqueConstraint(columnNames = "tripId"))
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TripEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String tripId; // Unique business identifier used in APIs

    private String bookingId;
    private String vehicleId;
    private String driverId;

    @Enumerated(EnumType.STRING)
    private TripStatus status;

    private LocalDate eta;
    private Instant timestamp;
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "trip", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TripEventEntity> events = new ArrayList<>();
}