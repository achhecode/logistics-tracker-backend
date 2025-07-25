package com.ar.logistics_models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentPreferenceDTO {
    private String totalAmount;
    private boolean payAdvance;
    private int advancePercent;
}
