package com.VooTreeVeeVuu.usecase.HotelUsecase;

import com.VooTreeVeeVuu.adapters.dto.HotelDTO;
import com.VooTreeVeeVuu.adapters.dto.HotelFacilityDTO;
import com.VooTreeVeeVuu.adapters.dto.HotelImageDTO;
import com.VooTreeVeeVuu.domain.entity.Hotel;
import com.VooTreeVeeVuu.domain.entity.HotelFacility;
import com.VooTreeVeeVuu.domain.entity.HotelImage;
import com.VooTreeVeeVuu.domain.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class GetAllHotelUseCase {
    @Autowired
    private HotelRepository hotelRepository;

    public List<HotelDTO> getAllHotel(){
        return hotelRepository.findAll().stream().map(this :: toDTO).collect(Collectors.toList());
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
        dto.setUser(hotel.getUser());
        dto.setRatings(hotel.getListRating());
        dto.setAccommodationType(hotel.getAccommodationType());
        dto.setRooms(hotel.getRooms());
        dto.setHotelImages( hotel.getHotelImages());
        dto.setHotelFacilities(hotel.getHotelFacilities());
        return dto;
    }
}
