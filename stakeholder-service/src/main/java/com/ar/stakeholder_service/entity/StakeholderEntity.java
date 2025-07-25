package com.ar.stakeholder_service.entity;


import com.ar.logistics_models.options.StakeholderType;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "stakeholders")
public class StakeholderEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String stakeHolderId;
    private String name;

    @Enumerated(EnumType.STRING)
    private StakeholderType type;

    private String contactEmail;

    private String contactPhone;

    private BigDecimal commissionRate;


}
