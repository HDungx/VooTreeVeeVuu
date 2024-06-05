package com.VooTreeVeeVuu.usecase.AccommodationTypeUsecase;

import com.VooTreeVeeVuu.adapters.dto.AccommodationTypeDTO;
import com.VooTreeVeeVuu.domain.entity.AccommodationType;
import com.VooTreeVeeVuu.domain.repository.AccommodationTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class GetAccommodationTypeUseCase {
    @Autowired
    private AccommodationTypeRepository accommodationTypeRepository;

    public Optional<AccommodationTypeDTO> getAccommodationTypeById(String id){
        return accommodationTypeRepository.findById(id).map(this :: toDTO);
    }

    private AccommodationTypeDTO toDTO(AccommodationType accommodationType) {
        AccommodationTypeDTO dto = new AccommodationTypeDTO();
        dto.setTypeId(accommodationType.getTypeId());
        dto.setTypeName(accommodationType.getTypeName());
        return dto;
    }
}
