package com.ar.invoice_service.dto;

import com.ar.invoice_service.model.InvoiceStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceDTO {
    private Long id;
    private Long tripId;           // Link to Trip
    private LocalDate issueDate;
    private LocalDate dueDate;
    private BigDecimal amount;
    private InvoiceStatus status;
}
