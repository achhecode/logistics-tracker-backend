package com.ar.booking_service.dto;

import com.ar.logistics_models.dto.AddressDTO;
import com.ar.logistics_models.dto.GoodsDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookingCostRequestDTO {
    private AddressDTO origin;
    private AddressDTO destination;
    private List<GoodsDTO> goodsList;
}
