package com.VooTreeVeeVuu.usecase.HotelImageUsecase;

import com.VooTreeVeeVuu.domain.repository.HotelImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeleteHotelImageUseCase {
    @Autowired
    private HotelImageRepository hotelImageRepository;

    @Transactional
    public void deleteHotelImage(Long id){hotelImageRepository.deleteById(id);
    }
}
