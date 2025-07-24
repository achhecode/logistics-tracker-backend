package com.ar.stakeholder_service.repository;

import com.ar.stakeholder_service.entity.Stakeholder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StakeholderRepository extends JpaRepository<Stakeholder, Long> {
}
