package com.ar.stakeholder_service.entity;

import com.ar.stakeholder_service.model.StakeholderType;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "stakeholders")
@Data
public class Stakeholder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String phone;

    @Enumerated(EnumType.STRING)
    private StakeholderType type;
}
