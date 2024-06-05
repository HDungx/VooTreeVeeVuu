package com.VooTreeVeeVuu.usecase.AccommodationTypeUsecase;

import com.VooTreeVeeVuu.adapters.dto.AccommodationTypeDTO;
import com.VooTreeVeeVuu.domain.entity.AccommodationType;
import com.VooTreeVeeVuu.domain.repository.AccommodationTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class CreateAccommodationTypeUseCase {
    @Autowired
    private AccommodationTypeRepository accommodationTypeRepository;

    @Transactional
    public AccommodationTypeDTO createAccommodationType (AccommodationTypeDTO typeDTO){
        AccommodationType accommodationType = toEntity(typeDTO);
        AccommodationType saved = accommodationTypeRepository.save(accommodationType);
        return toDTO(saved);
    }

    private AccommodationTypeDTO toDTO(AccommodationType accommodationType) {
        AccommodationTypeDTO dto = new AccommodationTypeDTO();
        dto.setTypeId(accommodationType.getTypeId());
        dto.setTypeName(accommodationType.getTypeName());
        return dto;
    }

    private AccommodationType toEntity(AccommodationTypeDTO typeDTO) {
        AccommodationType accommodationType = new AccommodationType();
        accommodationType.setTypeId(typeDTO.getTypeId());
        accommodationType.setTypeName(typeDTO.getTypeName());
        return accommodationType;
    }
}
