package com.ar.booking_service.mapper;

import com.ar.booking_service.entity.PaymentPreferenceEmbeddable;
import com.ar.logistics_models.dto.PaymentPreferenceDTO;

public class PaymentPreferenceMapper {
    public static PaymentPreferenceEmbeddable toEmbeddable(PaymentPreferenceDTO dto) {
        if (dto == null) return null;
        return PaymentPreferenceEmbeddable.builder()
                .payAdvance(dto.isPayAdvance())
                .totalAmount(dto.getTotalAmount())
                .advancePercent(dto.getAdvancePercent())
                .build();
    }

    public static PaymentPreferenceDTO toDTO(PaymentPreferenceEmbeddable emb) {
        if (emb == null) return null;
        return PaymentPreferenceDTO.builder()
                .payAdvance(emb.isPayAdvance())
                .totalAmount(emb.getTotalAmount())
                .advancePercent(emb.getAdvancePercent())
                .build();
    }
}
