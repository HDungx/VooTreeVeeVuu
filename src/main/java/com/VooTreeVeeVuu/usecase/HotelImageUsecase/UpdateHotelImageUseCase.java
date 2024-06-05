package com.VooTreeVeeVuu.usecase.HotelImageUsecase;

import com.VooTreeVeeVuu.adapters.dto.HotelImageDTO;
import com.VooTreeVeeVuu.domain.entity.HotelImage;
import com.VooTreeVeeVuu.domain.repository.HotelImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UpdateHotelImageUseCase {
    @Autowired
    private HotelImageRepository hotelImageRepository;

    @Transactional
    public Optional<HotelImageDTO> updateHotelImage(Long id, HotelImageDTO hotelImageDTO){
        return hotelImageRepository.findById(id).map(hotelImage -> {
            hotelImage.setPath(hotelImageDTO.getPath());
            hotelImage.setHotel(hotelImageDTO.getHotel());
            HotelImage updated = hotelImageRepository.save(hotelImage);
            return toDTO(updated);
        });
    }

    private HotelImageDTO toDTO(HotelImage hotelImage) {
        HotelImageDTO dto = new HotelImageDTO();
        dto.setPath(hotelImage.getPath());
        dto.setHotel(hotelImage.getHotel());
        return dto;
    }
}
