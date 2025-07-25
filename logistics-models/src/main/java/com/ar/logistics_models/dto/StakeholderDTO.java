package com.ar.logistics_models.dto;

import com.ar.logistics_models.options.StakeholderType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StakeholderDTO {
    private String stakeHolderId;
    private String name;
    private StakeholderType type;
    private String contactEmail;
    private String contactPhone;
    private BigDecimal commissionRate;
}
