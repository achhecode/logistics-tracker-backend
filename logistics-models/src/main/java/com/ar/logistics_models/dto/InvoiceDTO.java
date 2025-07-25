package com.ar.logistics_models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InvoiceDTO {
    private String invoiceId;
    private String bookingId;
    private String tripId;
    private List<InvoiceItemDTO> items;
    private double total;
    private double paid;
    private double balanceDue;
}
