package com.VooTreeVeeVuu.usecase.HotelFacilityUsecase;


import com.VooTreeVeeVuu.adapters.dto.HotelFacilityDTO;
import com.VooTreeVeeVuu.domain.entity.HotelFacility;
import com.VooTreeVeeVuu.domain.repository.HotelFacilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UpdateHotelFacilityUseCase {
//    @Autowired
//    private HotelFacilityRepository hotelFacilityRepository;
//
//    @Transactional
//    public Optional<HotelFacilityDTO> updateHotelFacility(Long id, HotelFacilityDTO hotelFacilityDTO){
//        return hotelFacilityRepository.findById(id).map(hotelFacility -> {
//            hotelFacility.setFacility(hotelFacilityDTO.getFacilityId());
//            hotelFacility.setHotel(hotelFacilityDTO.getHotel());
//            HotelFacility updated = hotelFacilityRepository.save(hotelFacility);
//            return toDTO(updated);
//        });
//    }
//
//    private HotelFacilityDTO toDTO(HotelFacility hotelFacility) {
//        HotelFacilityDTO dto = new HotelFacilityDTO();
//        dto.setFacility(hotelFacility.getFacility());
//        dto.setHotel(hotelFacility.getHotel());
//        return dto;
//    }
}
