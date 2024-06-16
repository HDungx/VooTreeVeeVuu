package com.VooTreeVeeVuu.usecase.HotelUsecase;


import com.VooTreeVeeVuu.adapters.dto.HotelDTO;
import com.VooTreeVeeVuu.domain.entity.Hotel;
import com.VooTreeVeeVuu.domain.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UpdateHotelUseCase {
//    @Autowired
//    private HotelRepository hotelRepository;
//
//    @Transactional
//    public Optional<HotelDTO> updateHotelDTO(Long id, HotelDTO hotelDTO){
//        return hotelRepository.findById(id).map(hotel -> {
//            hotel.setAddress(hotelDTO.getAddress());
//            hotel.setHotelName(hotelDTO.getHotelName());
//            hotel.setCity(hotelDTO.getCity());
//            hotel.setHotelPhoneNum(hotelDTO.getHotelPhoneNum());
//            hotel.setHotelStars(hotelDTO.getHotelStars());
//            hotel.setHotelDescription(hotelDTO.getHotelDescription());
//            hotel.setStatus(hotelDTO.getStatus());
//            hotel.setCheckInTime(hotelDTO.getCheckInTime());
//            hotel.setCheckOutTime(hotelDTO.getCheckOutTime());
//            hotel.setHotelImages(hotelDTO.getHotelImages());
//            hotel.setHotelFacilities(hotelDTO.getHotelFacilities());
//            hotel.setUser(hotelDTO.getUser());
//            Hotel updated = hotelRepository.save(hotel);
//            return toDTO(updated);
//        });
//    }
//
//    private HotelDTO toDTO(Hotel hotel) {
//        HotelDTO dto = new HotelDTO();
//        dto.setAddress(hotel.getAddress());
//        dto.setHotelName(hotel.getHotelName());
//        dto.setCity(hotel.getCity());
//        dto.setHotelPhoneNum(hotel.getHotelPhoneNum());
//        dto.setHotelStars(hotel.getHotelStars());
//        dto.setHotelDescription(hotel.getHotelDescription());
//        dto.setStatus(hotel.getStatus());
//        dto.setCheckInTime(hotel.getCheckInTime());
//        dto.setCheckOutTime(hotel.getCheckOutTime());
//        dto.setUser(hotel.getUser());
//        dto.setHotelImages(hotel.getHotelImages());
//        dto.setHotelFacilities(hotel.getHotelFacilities());
//        return dto;
//    }





}
