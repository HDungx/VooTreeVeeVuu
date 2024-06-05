package com.VooTreeVeeVuu.usecase.AccommodationTypeUsecase;

import com.VooTreeVeeVuu.adapters.dto.AccommodationTypeDTO;
import com.VooTreeVeeVuu.domain.entity.AccommodationType;
import com.VooTreeVeeVuu.domain.repository.AccommodationTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetAllAccommodationTypeUseCase {
    @Autowired
    private AccommodationTypeRepository accommodationTypeRepository;

    public List<AccommodationTypeDTO>getAllAccommodationTypeDTOS(){
        return accommodationTypeRepository.findAll().stream().map(this :: toDTO).collect(Collectors.toList());
    }

    private AccommodationTypeDTO toDTO(AccommodationType accommodationType) {
        AccommodationTypeDTO dto =new AccommodationTypeDTO();
        dto.setId(accommodationType.getId());
        dto.setTypeName(accommodationType.getTypeName());
        return dto;
    }
}
