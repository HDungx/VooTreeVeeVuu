package com.VooTreeVeeVuu.adapters.controller;


import com.VooTreeVeeVuu.adapters.dto.FacilityDTO;
import com.VooTreeVeeVuu.domain.entity.Facility;
import com.VooTreeVeeVuu.domain.repository.FacilityRepository;
import com.VooTreeVeeVuu.usecase.FacilityUsecase.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/facilities")
public class FacilityController {
    @Autowired
    private CreateFacilityUseCase createFacilityUseCase;

    @Autowired
    private UpdateFacilityUseCase updateFacilityUseCase;

    @Autowired
    private DeleteFacilityUseCase deleteFacilityUseCase;

    @Autowired
    private GetAllFacilityUseCase getAllFacilityUseCase;

    @Autowired
    private GetFacilityUseCase getFacilityUseCase;

    @GetMapping()
    public List<FacilityDTO> getAllFacility(){
        return getAllFacilityUseCase.getAllFacility();
    }

    @GetMapping ("/{id}")
    public Optional<FacilityDTO> getFacilityById (@PathVariable Integer id){
        return getFacilityUseCase.getFacilityById(id);
    }

    @PostMapping
    public FacilityDTO createFacility (@RequestBody FacilityDTO dto) {
        return createFacilityUseCase.createFacility(dto);
    }

    @PutMapping ("/update/{id}")
    public Optional<FacilityDTO> updateFacility (@RequestBody FacilityDTO dto, @PathVariable Integer id) {
        return updateFacilityUseCase.updateFacility(id,dto);
    }

    @DeleteMapping ("/delete/{id}")
    public void deleteFacility (@PathVariable Integer id) {
        deleteFacilityUseCase.deleteFacility(id);
    }
}
