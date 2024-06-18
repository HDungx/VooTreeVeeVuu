package com.VooTreeVeeVuu.usecase.HotelUsecase.GetHotel;

import com.VooTreeVeeVuu.dto.GetAllHotelDTO;
import com.VooTreeVeeVuu.domain.entity.Hotel;
import com.VooTreeVeeVuu.domain.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetHotelImpl implements GetHotel{
    @Autowired
    private HotelRepository hotelRepository;

    public Optional<GetAllHotelDTO> getHotelById(Long id){
        return hotelRepository.findById(id).map(this :: toDTO);
    }

    private GetAllHotelDTO toDTO (Hotel hotel) {
        GetAllHotelDTO hotelDTO = new GetAllHotelDTO();
        hotelDTO.setId(hotel.getId());
        hotelDTO.setAddress(hotel.getAddress());
        hotelDTO.setHotelName(hotel.getHotelName());
        hotelDTO.setCity(hotel.getCity());
        hotelDTO.setHotelPhoneNum(hotel.getHotelPhoneNum());
        hotelDTO.setHotelStars(hotel.getHotelStars());
        hotelDTO.setHotelDescription(hotel.getHotelDescription());
        hotelDTO.setCheckInTime(hotel.getCheckInTime());
        hotelDTO.setCheckOutTime(hotel.getCheckOutTime());
        hotelDTO.setStatus(hotel.getStatus());
        hotelDTO.setAccommodationType(hotel.getAccommodationType());
        hotelDTO.setHotelFacilities(hotel.getHotelFacilities());
        hotelDTO.setUser(hotel.getUser());
        hotelDTO.setHotelImages(hotel.getHotelImages());
        hotelDTO.setRooms(hotel.getRooms());
        hotelDTO.setRatings(hotel.getListRating());
        return hotelDTO;
    }
}
