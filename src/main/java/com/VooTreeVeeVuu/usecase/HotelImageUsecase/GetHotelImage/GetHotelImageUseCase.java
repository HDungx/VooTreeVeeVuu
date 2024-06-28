package com.VooTreeVeeVuu.usecase.HotelImageUsecase.GetHotelImage;

import com.VooTreeVeeVuu.domain.entity.HotelImage;
import com.VooTreeVeeVuu.domain.repository.HotelImageRepository;
import com.VooTreeVeeVuu.dto.HotelImageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;

@Service
public class GetHotelImageUseCase {
    @Autowired
    private HotelImageRepository hotelImageRepository;

    public Optional<HotelImageDTO> getHotelImageById(Long id) {
        return hotelImageRepository.findById(id).map(this::toDTO);
    }

    private HotelImageDTO toDTO(HotelImage hotelImage) {
        HotelImageDTO dto = new HotelImageDTO();
        dto.setImageName(hotelImage.getImageName());
        dto.setImageType(hotelImage.getImageType());
        dto.setImageBase64(Arrays.toString(hotelImage.getImageBase64()));
        return dto;
    }
}
