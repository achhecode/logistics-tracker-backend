package com.ar.trip_service.entity;

import com.ar.logistics_models.options.EventType;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "trip_events")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TripEventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Foreign key: trip_id references trips(id)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "trip_id", nullable = false)
    private TripEntity trip;

    @Enumerated(EnumType.STRING)
    private EventType eventType;

    private String location;
    private String description;
    private Instant timestamp;
    private BigDecimal cost;
}