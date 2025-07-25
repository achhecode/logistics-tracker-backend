package com.ar.booking_service.dto;

import com.ar.logistics_models.dto.AddressDTO;
import com.ar.logistics_models.dto.GoodsDTO;
import com.ar.logistics_models.dto.PaymentPreferenceDTO;
import com.ar.logistics_models.dto.ReferralDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookingRequestDTO {
    private String customerId;
    private AddressDTO origin;
    private AddressDTO destination;
    private List<GoodsDTO> goodsList;
    private PaymentPreferenceDTO paymentPreference;
    private ReferralDTO referral;
    private String brokerId; // optional
}
