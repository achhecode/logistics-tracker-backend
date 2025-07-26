package com.ar.logistics_models.dto;

import com.ar.logistics_models.options.BookingStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookingDTO {
    private String bookingId;
    private String customerId;
    private List<GoodsDTO> goodsList;
    private AddressDTO sender;
    private AddressDTO receiver;
    private String brokerId; // Optional
    private BookingStatus status;
    private PaymentPreferenceDTO paymentPreference;
    private ReferralDTO referral;
}

