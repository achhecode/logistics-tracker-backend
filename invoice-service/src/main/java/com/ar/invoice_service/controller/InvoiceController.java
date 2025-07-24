package com.ar.invoice_service.controller;

import com.ar.invoice_service.dto.InvoiceDTO;
import com.ar.invoice_service.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/invoices")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @PostMapping
    public ResponseEntity<InvoiceDTO> create(@RequestBody InvoiceDTO dto) {
        return ResponseEntity.ok(invoiceService.createInvoice(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<InvoiceDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(invoiceService.getInvoiceById(id));
    }
}
