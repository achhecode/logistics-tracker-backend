package com.ar.booking_service.util;

import com.ar.booking_service.dto.BookingRequestDTO;
import com.ar.booking_service.dto.BookingResponseDTO;
import com.ar.booking_service.entity.BookingEntity;

public class BookingMapper {

    public static BookingEntity toEntity(BookingRequestDTO dto) {
        return BookingEntity.builder()
                .bookingId(null) // generated in service
                .customerId(dto.getCustomerId())
                .sender(AddressMapper.toEmbeddable(dto.getOrigin()))
                .receiver(AddressMapper.toEmbeddable(dto.getDestination()))
                .goodsList(dto.getGoodsList().stream()
                        .map(GoodsMapper::toEmbeddable)
                        .toList())
                .paymentPreference(PaymentPreferenceMapper.toEmbeddable(dto.getPaymentPreference()))
                .referral(ReferralMapper.toEmbeddable(dto.getReferral()))
                .brokerId(dto.getBrokerId())
                .status(null) // set in service
                .build();
    }

    public static BookingResponseDTO toResponseDTO(BookingEntity entity) {
        return BookingResponseDTO.builder()
                .bookingId(entity.getBookingId())
                .customerId(entity.getCustomerId())
                .origin(AddressMapper.toDTO(entity.getSender()))
                .destination(AddressMapper.toDTO(entity.getReceiver()))
                .goodsList(entity.getGoodsList().stream()
                        .map(GoodsMapper::toDTO)
                        .toList())
                .paymentPreference(PaymentPreferenceMapper.toDTO(entity.getPaymentPreference()))
                .referral(ReferralMapper.toDTO(entity.getReferral()))
                .brokerId(entity.getBrokerId())
                .status(entity.getStatus())
                .build();
    }
}
