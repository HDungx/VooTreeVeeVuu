package com.VooTreeVeeVuu.usecase.HotelImageUsecase.GetAllHotelImage;

import com.VooTreeVeeVuu.dto.HotelImageDTO;
import com.VooTreeVeeVuu.domain.entity.HotelImage;
import com.VooTreeVeeVuu.domain.repository.HotelImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetAllHotelImageImpl implements GetAllHotelImage{
    @Autowired
    private HotelImageRepository hotelImageRepository;

    public List<HotelImageDTO> getAllHotelImage(){
        return hotelImageRepository.findAll().stream().map(this :: toDTO).collect(Collectors.toList());
    }

    private HotelImageDTO toDTO(HotelImage hotelImage) {
        HotelImageDTO dto = new HotelImageDTO();
        dto.setId(hotelImage.getId());
        dto.setPath(hotelImage.getPath());
        return dto;
    }
}
