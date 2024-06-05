package com.VooTreeVeeVuu.usecase.HotelFacilityUsecase;

import com.VooTreeVeeVuu.domain.repository.HotelFacilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeleteHotelFacilityUseCase {
    @Autowired
    private HotelFacilityRepository hotelFacilityRepository;

    @Transactional
    public void deleteHotelFacility(Long id){hotelFacilityRepository.deleteById(id);
    }
}
