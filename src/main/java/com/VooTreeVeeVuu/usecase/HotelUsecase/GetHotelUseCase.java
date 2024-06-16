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

    private HotelDTO toDTO (Hotel hotel) {
        HotelDTO hotelDTO = new HotelDTO();
        hotelDTO.setAddress(hotel.getAddress());
        hotelDTO.setHotelName(hotel.getHotelName());
        hotelDTO.setCity(hotel.getCity());
        hotelDTO.setHotelPhoneNum(hotel.getHotelPhoneNum());
        hotelDTO.setHotelStars(hotel.getHotelStars());
        hotelDTO.setHotelDescription(hotel.getHotelDescription());
        hotelDTO.setCheckInTime(hotel.getCheckInTime());
        hotelDTO.setCheckOutTime(hotel.getCheckOutTime());
        hotelDTO.setAccommodationTypeId(hotel.getAccommodationType().getId());
        hotelDTO.setUserId(hotel.getUser().getId());
        return hotelDTO;
    }
}
