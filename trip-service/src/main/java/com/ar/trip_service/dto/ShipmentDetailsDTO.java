package com.ar.trip_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShipmentDetailsDTO {
    private double weight;
    private String itemCategory;
    private String originCountry;
    private String originCity;
    private int originPin;
    private String destCountry;
    private String destCity;
    private int destPin;
}
