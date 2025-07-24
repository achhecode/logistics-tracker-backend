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

    private String trackingId; // TODO: need to move to appropriate model

    private String origin;
    private String destination;
    private LocalDate startDate;
    private LocalDate expectedDeliveryDate;
    private LocalDate actualDeliveryDate;

    @Enumerated(EnumType.STRING)
    private TripStatus status;

//    @ManyToOne
//    private Consignee consigneeId;

    private String consigneeName;

//    @ManyToOne
//    private Broker brokerId;

    private String brokerName;

//    @ManyToOne
//    private Driver driver;

    private String driver;

}
