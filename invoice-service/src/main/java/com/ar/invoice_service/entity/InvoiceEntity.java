package com.ar.invoice_service.entity;

import com.ar.logistics_models.options.InvoiceStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "invoices")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
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

    private LocalDateTime createdAt;
    private LocalDateTime paidAt;

    @OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL)
    private List<InvoiceItemEntity> items;
    private BigDecimal totalPaidAmount;

}
