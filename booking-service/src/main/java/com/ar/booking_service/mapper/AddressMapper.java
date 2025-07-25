package com.ar.booking_service.mapper;

import com.ar.booking_service.entity.AddressEmbeddable;
import com.ar.logistics_models.dto.AddressDTO;

public class AddressMapper {
    public static AddressEmbeddable toEmbeddable(AddressDTO dto) {
        return AddressEmbeddable.builder()
                .country(dto.getCountry())
                .city(dto.getCity())
                .line1(dto.getLine1())
                .line2(dto.getLine2())
                .landmark(dto.getLandmark())
                .pinCode(dto.getPinCode())
                .contactPerson(UserContactMapper.toEmbeddable(dto.getContactPerson()))
                .build();
    }

    public static AddressDTO toDTO(AddressEmbeddable emb) {
        return AddressDTO.builder()
                .country(emb.getCountry())
                .state(emb.getState())
                .city(emb.getCity())
                .line1(emb.getLine1())
                .line2(emb.getLine2())
                .landmark(emb.getLandmark())
                .pinCode(emb.getPinCode())
                .contactPerson(UserContactMapper.toDTO(emb.getContactPerson()))
                .build();
    }
}
