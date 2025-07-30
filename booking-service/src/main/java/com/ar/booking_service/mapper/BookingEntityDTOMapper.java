package com.ar.booking_service.mapper;

import com.ar.booking_service.entity.*;
import com.ar.logistics_models.dto.*;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper(componentModel = "spring")
public interface BookingEntityDTOMapper {
    BookingDTO toDTO(BookingEntity entity);
    BookingEntity toEntity(BookingDTO dto);

    List<GoodsDTO> toDTO(List<GoodsEmbeddable> entities);
    List<GoodsEmbeddable> toEntities(List<GoodsDTO> dtos);

    AddressDTO toDTO(AddressEmbeddable entity);
    AddressEmbeddable toEntity(AddressDTO dto);

    PaymentPreferenceDTO toDTO(PaymentPreferenceEmbeddable entity);
    PaymentPreferenceEmbeddable toEntity(PaymentPreferenceDTO dto);

    ReferralDTO toDTO(ReferralEmbeddable entity);
    ReferralEmbeddable toEntity(ReferralDTO dto);
}

