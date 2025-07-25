package com.ar.invoice_service.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "invoices")
public class InvoiceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bookingId;
    private String tripId;

    private String issuedTo; // userId

    @Enumerated(EnumType.STRING)
    private InvoiceStatus status;

    private BigDecimal subtotal;
    private BigDecimal taxes;
    private BigDecimal total;
    private BigDecimal paidAmount;

    private Instant createdAt;
    private Instant paidAt;

    @OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL)
    private List<InvoiceItemEntity> items;

    public enum InvoiceStatus {
        DRAFT, ISSUED, PAID, OVERDUE
    }
}
