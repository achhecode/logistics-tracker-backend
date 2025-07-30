package com.ar.invoice_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "invoice_items")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InvoiceItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "invoice_id")
    private InvoiceEntity invoice;

    private String description;
    private BigDecimal amount;
}
