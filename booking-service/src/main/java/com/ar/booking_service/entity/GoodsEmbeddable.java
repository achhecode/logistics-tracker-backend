package com.ar.booking_service.entity;

import com.ar.logistics_models.options.GoodsType;
import com.ar.logistics_models.options.MassUnit;
import com.ar.logistics_models.options.UnitType;
import com.ar.logistics_models.options.VolumeUnit;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@Builder
@NoArgsConstructor // Required for JPA
@AllArgsConstructor
public class GoodsEmbeddable {
    @Enumerated(EnumType.STRING)
    private GoodsType goodsType;
    private int quantity;
    @Enumerated(EnumType.STRING)
    private UnitType unitType;
    @Enumerated(EnumType.STRING)
    private MassUnit massUnit;
    @Enumerated(EnumType.STRING)
    private VolumeUnit volumeUnit;
    private String unitLabel;
}

