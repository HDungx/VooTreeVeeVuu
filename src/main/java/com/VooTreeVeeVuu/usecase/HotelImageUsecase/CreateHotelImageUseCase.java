package com.VooTreeVeeVuu.usecase.HotelImageUsecase;

import com.VooTreeVeeVuu.adapters.dto.HotelImageDTO;
import com.VooTreeVeeVuu.domain.entity.HotelImage;
import com.VooTreeVeeVuu.domain.repository.HotelImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreateHotelImageUseCase {
    @Autowired
    private HotelImageRepository hotelImageRepository;

    @Transactional
    public HotelImageDTO createHotelImage (HotelImageDTO hotelImageDTO){
        HotelImage hotelImage = toEntity(hotelImageDTO);
        HotelImage saved = hotelImageRepository.save(hotelImage);
        return toDTO(saved);
    }

    private HotelImageDTO toDTO(HotelImage hotelImage) {
        HotelImageDTO dto = new HotelImageDTO();
        dto.setPath(hotelImage.getPath());
        dto.setHotel(hotelImage.getHotel());
        return dto;
    }

    private HotelImage toEntity(HotelImageDTO hotelImageDTO) {
        HotelImage hotelImage = new HotelImage();
        hotelImage.setPath(hotelImageDTO.getPath());
        hotelImage.setHotel(hotelImageDTO.getHotel());
        return hotelImage;
    }
}
