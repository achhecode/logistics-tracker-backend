package com.ar.invoice_service.service;

import com.ar.invoice_service.dto.InvoiceDTO;
import com.ar.invoice_service.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    public InvoiceDTO createInvoice(InvoiceDTO dto) {
        Invoice invoice = new Invoice();
        invoice.setTripId(dto.getTripId());
        invoice.setIssueDate(dto.getIssueDate());
        invoice.setDueDate(dto.getDueDate());
        invoice.setAmount(dto.getAmount());
        invoice.setStatus(dto.getStatus());

        Invoice saved = invoiceRepository.save(invoice);
        dto.setId(saved.getId());
        return dto;
    }

    public InvoiceDTO getInvoiceById(Long id) {
        Optional<Invoice> opt = invoiceRepository.findById(id);
        if (opt.isEmpty()) throw new RuntimeException("Invoice not found");

        Invoice i = opt.get();
        return new InvoiceDTO(i.getId(), i.getTripId(), i.getIssueDate(), i.getDueDate(), i.getAmount(), i.getStatus());
    }
}
