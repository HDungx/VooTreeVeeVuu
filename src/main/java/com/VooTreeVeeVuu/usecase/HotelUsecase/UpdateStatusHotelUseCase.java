package com.VooTreeVeeVuu.usecase.HotelUsecase;

import com.VooTreeVeeVuu.dto.HotelDTO;
import com.VooTreeVeeVuu.domain.entity.Hotel;
import com.VooTreeVeeVuu.domain.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateStatusHotelUseCase {
    @Autowired
    private HotelRepository hotelRepository;

    public Optional<HotelDTO> updateStatusHotel(Long id, HotelDTO hotelDTO){
        return hotelRepository.findById(id).map(hotel -> {
            hotel.setStatus(hotelDTO.getStatus());
            Hotel updated = hotelRepository.save(hotel);
            return toDTO(updated);
        });
    }

    private HotelDTO toDTO(Hotel hotel) {
        HotelDTO dto = new HotelDTO();
        dto.setStatus(hotel.getStatus());
        return dto;
    }
}
