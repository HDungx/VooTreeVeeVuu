package com.VooTreeVeeVuu.usecase.FacilityUsecase;

import com.VooTreeVeeVuu.adapters.dto.FacilityDTO;
import com.VooTreeVeeVuu.adapters.dto.GetAllRoomFacDTO;
import com.VooTreeVeeVuu.domain.entity.Facility;
import com.VooTreeVeeVuu.domain.repository.FacilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetFacilityUseCase {
    @Autowired
    private FacilityRepository facilityRepository;

    public Optional<FacilityDTO> getFacilityById(Long id){
        return facilityRepository.findById(id).map(this :: toDTO);
    }

    private FacilityDTO toDTO(Facility facility) {
        FacilityDTO dto = new FacilityDTO();
        dto.setFacId(facility.getFacId());
        dto.setFacType(facility.getFacType());
        dto.setFacName(facility.getFacName());
        dto.setFacIcon(facility.getFacIcon());
        return dto;
    }
}
