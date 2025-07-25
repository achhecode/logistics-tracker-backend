package com.ar.booking_service.util;

import com.ar.booking_service.entity.UserContactEmbeddable;
import com.ar.logistics_models.dto.UserContactDTO;

public class UserContactMapper {
    public static UserContactEmbeddable toEmbeddable(UserContactDTO dto) {
        return UserContactEmbeddable.builder()
                .name(dto.getName())
                .mobile(dto.getMobile())
                .build();
    }

    public static UserContactDTO toDTO(UserContactEmbeddable emb) {
        return UserContactDTO.builder()
                .name(emb.getName())
                .mobile(emb.getMobile())
                .build();
    }
}
