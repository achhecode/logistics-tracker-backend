package com.ar.stakeholder_service.controller;

import com.ar.logistics_models.dto.StakeholderDTO;
import com.ar.stakeholder_service.dto.StakeholderDTO;
import com.ar.stakeholder_service.service.StakeholderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/stakeholders")
public class StakeholderController {

    @Autowired
    private StakeholderService stakeholderService;

    @PostMapping
    public ResponseEntity<StakeholderDTO> create(@RequestBody StakeholderDTO dto) {
        return ResponseEntity.ok(stakeholderService.createStakeholder(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StakeholderDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(stakeholderService.getStakeholderById(id));
    }
}
