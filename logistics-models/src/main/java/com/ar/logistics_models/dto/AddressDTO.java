package com.ar.logistics_models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressDTO {
    private UserContactDTO contactPerson;
    private String country;
    private String state;
    private String city;
    private String line1;
    private String line2;
    private String landmark;
    private int pinCode;
}
