package com.ar.trip_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShipmentRequestDetailsDTO {
    private String originCountry;
    private String originCity;
    private String originAddress;
    private String originContactPerson;
    private String originMobile;
    private String originPin;
    private String destCountry;
    private String destCity;
    private String destAddress;
    private String destContactPerson;
    private String destMobile;
    private String destPin;
    private String itemCategory;
    private double weight;
    private String totalAmount;
    private String payAdvance;
    private int advancePercent;
    private String referredByType;
    private String referredByName;
}