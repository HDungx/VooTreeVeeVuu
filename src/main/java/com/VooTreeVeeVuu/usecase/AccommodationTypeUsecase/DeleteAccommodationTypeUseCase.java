package com.VooTreeVeeVuu.usecase.AccommodationTypeUsecase;

import com.VooTreeVeeVuu.domain.repository.AccommodationTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class DeleteAccommodationTypeUseCase {
    @Autowired
    private AccommodationTypeRepository accommodationTypeRepository;

    @Transactional
    public void deleteAccommodationType(String id){
        accommodationTypeRepository.deleteById(id);
    }
}
