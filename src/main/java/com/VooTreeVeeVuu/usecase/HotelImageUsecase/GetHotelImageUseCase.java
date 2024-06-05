package com.VooTreeVeeVuu.usecase.HotelImageUsecase;

import com.VooTreeVeeVuu.adapters.dto.HotelImageDTO;
import com.VooTreeVeeVuu.domain.entity.HotelImage;
import com.VooTreeVeeVuu.domain.repository.HotelImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetHotelImageUseCase {
    @Autowired
    private HotelImageRepository hotelImageRepository;

    public Optional<HotelImageDTO> getHotelImageById(Long id){
        return hotelImageRepository.findById(id).map(this :: toDTO);
    }

    private HotelImageDTO toDTO(HotelImage hotelImage) {
        HotelImageDTO dto = new HotelImageDTO();
        dto.setId(hotelImage.getId());
        dto.setPath(hotelImage.getPath());
        dto.setHotel(hotelImage.getHotel());
        return dto;
    }
}
