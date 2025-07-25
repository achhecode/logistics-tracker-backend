package com.ar.logistics_models.dto;

import com.ar.logistics_models.options.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentDTO {
    private PaymentMethod method;
    private double amount;
    private LocalDateTime paidAt;
    private String transactionId;
}
