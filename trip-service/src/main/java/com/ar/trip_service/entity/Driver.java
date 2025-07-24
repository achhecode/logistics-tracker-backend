package com.ar.trip_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Driver {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String licenseNumber;
}