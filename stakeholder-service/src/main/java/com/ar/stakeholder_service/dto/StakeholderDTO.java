package com.ar.stakeholder_service.dto;

import com.ar.stakeholder_service.model.StakeholderType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StakeholderDTO {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private StakeholderType type;
}
