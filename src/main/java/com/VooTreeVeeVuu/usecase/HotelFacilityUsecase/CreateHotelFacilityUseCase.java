package com.VooTreeVeeVuu.usecase.HotelFacilityUsecase;

import com.VooTreeVeeVuu.adapters.dto.FacilityDTO;
import com.VooTreeVeeVuu.adapters.dto.HotelFacilityDTO;
import com.VooTreeVeeVuu.domain.entity.Facility;
import com.VooTreeVeeVuu.domain.entity.HotelFacility;
import com.VooTreeVeeVuu.domain.repository.HotelFacilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreateHotelFacilityUseCase {
    @Autowired
    private HotelFacilityRepository hotelFacilityRepository;

    @Transactional
    public HotelFacilityDTO  createHotelFacility (HotelFacilityDTO hotelFacilityDTO){
        HotelFacility hotelFacility = toEntity(hotelFacilityDTO);
        HotelFacility saved = hotelFacilityRepository.save(hotelFacility);
        return toDTO(saved);
    }

    private HotelFacilityDTO toDTO(HotelFacility hotelFacility) {
        HotelFacilityDTO dto = new HotelFacilityDTO();
        dto.setFacility(hotelFacility.getFacility());
        dto.setHotel(hotelFacility.getHotel());
        return dto;
    }

    private HotelFacility toEntity(HotelFacilityDTO hotelFacilityDTO) {
        HotelFacility hotelFacility = new HotelFacility();
        hotelFacility.setFacility(hotelFacilityDTO.getFacility());
        hotelFacility.setHotel(hotelFacilityDTO.getHotel());
        return hotelFacility;
    }
}
