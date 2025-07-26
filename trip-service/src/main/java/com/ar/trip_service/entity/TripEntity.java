package com.ar.trip_service.entity;

import com.ar.logistics_models.options.TripStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "trips")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TripEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tripId;
    private String bookingId;
    private String vehicleId;
    private String driverId;

    @Enumerated(EnumType.STRING)
    private TripStatus status;
    private LocalDate eta;
    private Instant timestamp;
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "trip", cascade = CascadeType.ALL, orphanRemoval = true)
//    @JsonIgnore // if used in serialization
    private List<TripEventEntity> events = new ArrayList<>();

}
