package com.ar.invoice_service.mapper;

import com.ar.invoice_service.entity.InvoiceEntity;
import com.ar.invoice_service.entity.InvoiceItemEntity;
import com.ar.logistics_models.dto.InvoiceDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface InvoiceEntityDTOMapper {
    InvoiceDTO toDTO(InvoiceEntity entity);
    InvoiceEntity toEntity(InvoiceDTO dto);

    List<InvoiceDTO> toDTOs(List<InvoiceEntity> entities);
    List<InvoiceItemEntity> toEntities(List<InvoiceDTO> dtos);
}
