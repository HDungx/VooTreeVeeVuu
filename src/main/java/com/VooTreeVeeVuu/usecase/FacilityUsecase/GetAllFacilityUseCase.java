package com.VooTreeVeeVuu.usecase.FacilityUsecase;

import com.VooTreeVeeVuu.adapters.dto.FacilityDTO;
import com.VooTreeVeeVuu.domain.entity.Facility;
import com.VooTreeVeeVuu.domain.repository.FacilityRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class GetAllFacilityUseCase {
    @Autowired
    private FacilityRepository facilityRepository;

    public List<FacilityDTO> getAllFacility(){
        return facilityRepository.findAll().stream().map(this :: toDTO).collect(Collectors.toList());
    }

    private FacilityDTO toDTO(Facility facility) {
        FacilityDTO dto = new FacilityDTO();
        dto.setFacId(facility.getFacId());
        dto.setFacType(facility.getFacType());
        dto.setFacName(facility.getFacName());
        return dto;
    }
}
