package com.VooTreeVeeVuu.adapters.controller;


import com.VooTreeVeeVuu.adapters.dto.HotelFacilityDTO;
import com.VooTreeVeeVuu.usecase.HotelFacilityUsecase.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/hotelFacilities")
public class HotelFacilityController {
    @Autowired
    private CreateHotelFacilityUseCase createHotelFacilityUseCase;

    @Autowired
    private UpdateHotelFacilityUseCase updateHotelFacilityUseCase;

    @Autowired
    private DeleteHotelFacilityUseCase deleteHotelFacilityUseCase;

    @Autowired
    private GetAllHotelFacilityUseCase getAllHotelFacilityUseCase;

    @Autowired
    private GetHotelFacilityUseCase getHotelFacilityUseCase;

    @GetMapping()
    public List<HotelFacilityDTO> getAllHotelFacility(){
        return getAllHotelFacilityUseCase.getAllHotelFacility();
    }

    @GetMapping ("/{id}")
    public Optional<HotelFacilityDTO> getHotelFacilityById (@PathVariable Long id){
        return getHotelFacilityUseCase.getHotelFacilityById(id);
    }

    @PostMapping
    public HotelFacilityDTO createHotelFacility (@RequestBody HotelFacilityDTO dto) {
        return createHotelFacilityUseCase.createHotelFacility(dto);
    }

//    @PutMapping ("/update/{id}")
//    public Optional<HotelFacilityDTO> updateHotelFacility (@RequestBody HotelFacilityDTO dto, @PathVariable Long id) {
//        return updateHotelFacilityUseCase.updateHotelFacility(id,dto);
//    }

    @DeleteMapping ("/delete/{id}")
    public void deleteHotelFacility (@PathVariable Long id) {
        deleteHotelFacilityUseCase.deleteHotelFacility(id);
    }

}
