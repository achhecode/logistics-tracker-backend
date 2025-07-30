package com.ar.invoice_service.repository;

import com.ar.invoice_service.entity.InvoiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<InvoiceEntity, Long> {
}
