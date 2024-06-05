package com.VooTreeVeeVuu.usecase.FacilityUsecase;


import com.VooTreeVeeVuu.domain.repository.FacilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class DeleteFacilityUseCase {
    @Autowired
    private FacilityRepository facilityRepository;

    @Transactional
    public void deleteFacility(Integer id){facilityRepository.deleteById(id);
    }
}
