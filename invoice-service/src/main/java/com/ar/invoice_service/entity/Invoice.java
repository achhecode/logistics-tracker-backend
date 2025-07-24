package com.ar.invoice_service.entity;

import com.ar.invoice_service.model.InvoiceStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "invoices")
@Data
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long tripId;

    private LocalDate issueDate;
    private LocalDate dueDate;

    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private InvoiceStatus status;
}
