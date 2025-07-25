package com.ar.booking_service.mapper;

import com.ar.booking_service.entity.GoodsEmbeddable;
import com.ar.logistics_models.dto.GoodsDTO;

public class GoodsMapper {
    public static GoodsEmbeddable toEmbeddable(GoodsDTO dto) {
        return GoodsEmbeddable.builder()
                .goodsType(dto.getGoodsType())
                .quantity(dto.getQuantity())
                .unitType(dto.getUnitType())
                .massUnit(dto.getMassUnit())
                .volumeUnit(dto.getVolumeUnit())
                .unitLabel(dto.getUnitLabel())
                .build();
    }

    public static GoodsDTO toDTO(GoodsEmbeddable emb) {
        return GoodsDTO.builder()
                .goodsType(emb.getGoodsType())
                .quantity(emb.getQuantity())
                .unitType(emb.getUnitType())
                .massUnit(emb.getMassUnit())
                .volumeUnit(emb.getVolumeUnit())
                .unitLabel(emb.getUnitLabel())
                .build();
    }
}
