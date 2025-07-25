package com.ar.stakeholder_service.repository;

import com.ar.stakeholder_service.entity.StakeholderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StakeholderRepository extends JpaRepository<StakeholderEntity, Long> {
    Optional<StakeholderEntity> findByStakeHolderId(String stakeHolderId);
}
