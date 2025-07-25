package com.ar.booking_service.mapper;

import com.ar.booking_service.entity.ReferralEmbeddable;
import com.ar.logistics_models.dto.ReferralDTO;

public class ReferralMapper {
    public static ReferralEmbeddable toEmbeddable(ReferralDTO dto) {
        if (dto == null) return null;
        return ReferralEmbeddable.builder()
                .referredByType(dto.getReferredByType())
                .referredByName(dto.getReferredByName())
                .build();
    }

    public static ReferralDTO toDTO(ReferralEmbeddable emb) {
        if (emb == null) return null;
        return ReferralDTO.builder()
                .referredByType(emb.getReferredByType())
                .referredByName(emb.getReferredByName())
                .build();
    }
}
