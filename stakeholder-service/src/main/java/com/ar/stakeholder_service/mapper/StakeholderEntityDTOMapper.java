package com.ar.stakeholder_service.mapper;

import com.ar.logistics_models.dto.StakeholderDTO;
import com.ar.stakeholder_service.entity.StakeholderEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StakeholderEntityDTOMapper {
    StakeholderDTO toDTO(StakeholderEntity entity);
    StakeholderEntity toEntity(StakeholderDTO dto);
}
