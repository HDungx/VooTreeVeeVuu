package com.VooTreeVeeVuu.usecase.HotelUsecase;

import com.VooTreeVeeVuu.adapters.dto.BookingDTO;
import com.VooTreeVeeVuu.adapters.dto.HotelDTO;
import com.VooTreeVeeVuu.domain.entity.Hotel;
import com.VooTreeVeeVuu.domain.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetHotelUseCase {
    @Autowired
    private HotelRepository hotelRepository;

    public Optional<HotelDTO> getHotelById(Long id){
        return hotelRepository.findById(id).map(this :: toDTO);
    }

    private HotelDTO toDTO(Hotel hotel) {
        HotelDTO dto = new HotelDTO();
        dto.setId(hotel.getId());
        dto.setAddress(hotel.getAddress());
        dto.setHotelName(hotel.getHotelName());
        dto.setCity(hotel.getCity());
        dto.setHotelPhoneNum(hotel.getHotelPhoneNum());
        dto.setHotelStars(hotel.getHotelStars());
        dto.setHotelDescription(hotel.getHotelDescription());
        dto.setStatus(hotel.getStatus());
        dto.setCheckInTime(hotel.getCheckInTime());
        dto.setCheckOutTime(hotel.getCheckOutTime());
        dto.setPartner(hotel.getPartner());
//        dto.setHotelImages(hotel.getHotelImages().stream().map(this::toImageDTO).collect(Collectors.toList()));
//        dto.setHotelFacilities(hotel.getHotelFacilities().stream().map(this::toFacilityDTO).collect(Collectors.toList()));
        return dto;
    }
}
