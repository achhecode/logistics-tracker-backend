package com.ar.invoice_service.service;

import com.ar.invoice_service.entity.InvoiceEntity;
import com.ar.invoice_service.mapper.InvoiceEntityDTOMapper;
import com.ar.invoice_service.repository.InvoiceRepository;
import com.ar.logistics_models.dto.InvoiceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private InvoiceEntityDTOMapper invoiceEntityDTOMapper;


    public InvoiceDTO createInvoice(InvoiceDTO dto) {
        InvoiceEntity invoiceEntity = invoiceEntityDTOMapper.toEntity(dto);

        InvoiceEntity saved = invoiceRepository.save(invoiceEntity);
        return dto;
    }

    public InvoiceDTO getInvoiceById(Long id) {
        Optional<InvoiceEntity> opt = invoiceRepository.findById(id);
        if (opt.isEmpty()) throw new RuntimeException("Invoice not found");

        return invoiceEntityDTOMapper.toDTO(opt.get());
    }
}
