package com.ar.stakeholder_service.service;

import com.ar.stakeholder_service.dto.StakeholderDTO;
import com.ar.stakeholder_service.entity.Stakeholder;
import com.ar.stakeholder_service.repository.StakeholderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StakeholderService {

    @Autowired
    private StakeholderRepository stakeholderRepository;

    public StakeholderDTO createStakeholder(StakeholderDTO dto) {
        Stakeholder stakeholder = new Stakeholder();
        stakeholder.setName(dto.getName());
        stakeholder.setEmail(dto.getEmail());
        stakeholder.setPhone(dto.getPhone());
        stakeholder.setType(dto.getType());

        Stakeholder saved = stakeholderRepository.save(stakeholder);

        dto.setId(saved.getId());
        return dto;
    }

    public StakeholderDTO getStakeholderById(Long id) {
        Optional<Stakeholder> optional = stakeholderRepository.findById(id);
        if (optional.isEmpty()) throw new RuntimeException("Stakeholder not found");

        Stakeholder s = optional.get();
        return new StakeholderDTO(s.getId(), s.getName(), s.getEmail(), s.getPhone(), s.getType());
    }
}
