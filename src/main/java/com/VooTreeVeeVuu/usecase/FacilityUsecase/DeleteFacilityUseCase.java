package com.VooTreeVeeVuu.usecase.FacilityUsecase;


import com.VooTreeVeeVuu.domain.repository.FacilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeleteFacilityUseCase {
    @Autowired
    private FacilityRepository facilityRepository;

    @Transactional
    public void deleteFacility(Integer id){facilityRepository.deleteById(id);
    }
}
