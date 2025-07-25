package com.ar.stakeholder_service.service;

import com.ar.logistics_models.dto.StakeholderDTO;
import com.ar.stakeholder_service.repository.StakeholderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StakeholderService {

    @Autowired
    private StakeholderRepository stakeholderRepository;

    public StakeholderDTO createStakeholder(StakeholderDTO dto) {

        return null;
    }

    public StakeholderDTO getStakeholderById(Long id) {
        return null;
    }
}
