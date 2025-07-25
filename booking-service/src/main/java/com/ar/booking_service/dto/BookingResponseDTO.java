package com.ar.booking_service.dto;

import com.ar.logistics_models.dto.AddressDTO;
import com.ar.logistics_models.dto.GoodsDTO;
import com.ar.logistics_models.dto.PaymentPreferenceDTO;
import com.ar.logistics_models.dto.ReferralDTO;
import com.ar.logistics_models.options.BookingStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookingResponseDTO {
    private String bookingId;
    private String customerId;
    private AddressDTO origin;
    private AddressDTO destination;
    private List<GoodsDTO> goodsList;
    private PaymentPreferenceDTO paymentPreference;
    private ReferralDTO referral;
    private String brokerId;
    private BookingStatus status;
}
