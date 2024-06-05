package com.VooTreeVeeVuu.usecase.HotelFacilityUsecase;

import com.VooTreeVeeVuu.adapters.dto.HotelDTO;
import com.VooTreeVeeVuu.adapters.dto.HotelFacilityDTO;
import com.VooTreeVeeVuu.domain.entity.HotelFacility;
import com.VooTreeVeeVuu.domain.repository.HotelFacilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetHotelFacilityUseCase {
    @Autowired
    private HotelFacilityRepository hotelFacilityRepository;

    public Optional<HotelFacilityDTO> getHotelFacilityById(Long id){
        return hotelFacilityRepository.findById(id).map(this :: toDTO);
    }

    private HotelFacilityDTO toDTO(HotelFacility hotelFacility) {
        HotelFacilityDTO dto = new HotelFacilityDTO();
        dto.setId(hotelFacility.getId());
        dto.setFacility(hotelFacility.getFacility());
        dto.setHotel(hotelFacility.getHotel());
        return dto;
    }
}
