package com.ar.logistics_models.dto;

import com.ar.logistics_models.options.InvoiceStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InvoiceDTO {
    private String bookingId;
    private String tripId;
    private String issuedTo;
    private InvoiceStatus status;
    private BigDecimal subtotal;
    private BigDecimal taxes;
    private BigDecimal total;
    private BigDecimal paidAmount;
    private LocalDateTime createdAt;
    private LocalDateTime paidAt;
    private List<InvoiceItemDTO> items;
    private BigDecimal totalPaidAmount;
}
