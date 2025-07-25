package com.ar.booking_service.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@Builder
@NoArgsConstructor // Required for JPA
@AllArgsConstructor
public class PaymentPreferenceEmbeddable {
    private String totalAmount;
    private boolean payAdvance;
    private int advancePercent;
}
