package com.ar.logistics_models.dto;

import com.ar.logistics_models.options.GoodsType;
import com.ar.logistics_models.options.MassUnit;
import com.ar.logistics_models.options.UnitType;
import com.ar.logistics_models.options.VolumeUnit;

public class GoodsDTO {
    private int id;
    private GoodsType goodsType;
    private int quantity;
    private UnitType unitType;
    private MassUnit massUnit;
    private VolumeUnit volumeUnit;
    private String unitLabel;   // optional if unit type is COUNT: custom text like "pieces", "packs", etc.
    private int declaredValue;
}
