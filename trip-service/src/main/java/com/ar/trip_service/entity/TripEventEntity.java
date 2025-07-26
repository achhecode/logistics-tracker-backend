package com.ar.trip_service.entity;

import com.ar.logistics_models.options.EventType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @ManyToOne
    @JoinColumn(name = "trip_id")
    private TripEntity trip;

    @Enumerated(EnumType.STRING)
    private EventType eventType;

    private String location;

    private String description;

    private Instant timestamp;

    private BigDecimal cost;
}
