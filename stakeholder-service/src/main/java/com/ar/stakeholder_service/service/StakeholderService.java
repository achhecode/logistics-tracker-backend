package com.ar.stakeholder_service.service;

import com.ar.logistics_models.dto.StakeholderDTO;
import com.ar.stakeholder_service.entity.StakeholderEntity;
import com.ar.stakeholder_service.mapper.StakeholderEntityDTOMapper;
import com.ar.stakeholder_service.repository.StakeholderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StakeholderService {

    @Autowired
    private StakeholderRepository stakeholderRepository;

    @Autowired
    private StakeholderEntityDTOMapper stakeholderEntityDTOMapper;

    public StakeholderDTO createStakeholder(StakeholderDTO stakeholderDTO) {
        StakeholderEntity entity = stakeholderEntityDTOMapper.toEntity(stakeholderDTO);
        stakeholderRepository.save(entity);
        return stakeholderEntityDTOMapper.toDTO(entity);
    }

    public StakeholderDTO getStakeholderById(Long id) {
        StakeholderEntity entity = stakeholderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Stakeholder not found: " + id));
        return stakeholderEntityDTOMapper.toDTO(entity);
    }

    public StakeholderDTO getStakeholderByStakeHolderId(String stakeHolderId) {
        StakeholderEntity entity = stakeholderRepository.findByStakeHolderId(stakeHolderId)
                .orElseThrow(() -> new RuntimeException("Stakeholder not found: " + stakeHolderId));
        return stakeholderEntityDTOMapper.toDTO(entity);
    }
}
