package com.ar.logistics_models.dto;

import com.ar.logistics_models.options.StakeholderType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StakeholderDTO {
    private String id;
    private StakeholderType type;
    private double commissionRate;
}
