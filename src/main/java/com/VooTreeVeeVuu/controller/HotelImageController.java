package com.VooTreeVeeVuu.controller;

import com.VooTreeVeeVuu.dto.HotelImageDTO;
import com.VooTreeVeeVuu.usecase.HotelImageUsecase.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/hotelImages")
public class HotelImageController {
//    @Autowired
//    private CreateHotelImageUseCase createHotelImageUseCase;

//    @Autowired
//    private UpdateHotelImageUseCase updateHotelImageUseCase;

    @Autowired
    private DeleteHotelImageUseCase deleteHotelImageUseCase;

    @Autowired
    private GetAllHotelImageUseCase getAllHotelImageUseCase;

    @Autowired
    private GetHotelImageUseCase getHotelImageUseCase;

    @GetMapping()
    public List<HotelImageDTO> getAllHotelImage(){
        return getAllHotelImageUseCase.getAllHotelImage();
    }

    @GetMapping ("/{id}")
    public Optional<HotelImageDTO> getHotelImageById (@PathVariable Long id){
        return getHotelImageUseCase.getHotelImageById(id);
    }

//    @PostMapping
//    public HotelImageDTO createHotelImage (@RequestBody HotelImageDTO dto) {
//        return createHotelImageUseCase.createHotelImage(dto);
//    }
//
//    @PutMapping ("/update/{id}")
//    public Optional<HotelImageDTO> updateHotelImage (@RequestBody HotelImageDTO dto, @PathVariable Long id) {
//        return updateHotelImageUseCase.updateHotelImage(id,dto);
//    }

    @DeleteMapping ("/delete/{id}")
    public void deleteHotelImage (@PathVariable Long id) {
        deleteHotelImageUseCase.deleteHotelImage(id);
    }



}
