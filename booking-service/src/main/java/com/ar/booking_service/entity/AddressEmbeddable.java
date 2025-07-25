package com.ar.booking_service.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressEmbeddable {
    private String country;
    private String state;
    private String city;
    private String line1;
    private String line2;
    private String landmark;
    private int pinCode;

    @Embedded
    private UserContactEmbeddable contactPerson;
}
