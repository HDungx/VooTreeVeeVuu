package com.VooTreeVeeVuu.adapters.controller;

import com.VooTreeVeeVuu.adapters.dto.HotelDTO;
import com.VooTreeVeeVuu.usecase.HotelUsecase.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin ("*")
@RestController
@RequestMapping ("/api/hotels")
public class HotelController {
    @Autowired
    private CreateHotelUseCase createHotelUseCase;

    @Autowired
    private UpdateHotelUseCase updateHotelUseCase;

    @Autowired
    private GetAllHotelUseCase getAllHotelUseCase;

    @Autowired
    private GetHotelUseCase getHotelUseCase;

    @Autowired
    private DeleteHotelUseCase deleteHotelUseCase;

    @Autowired
    private UpdateStatusHotelUseCase updateStatusHotelUseCase;

    @GetMapping()
    public List<HotelDTO> getAllHotel(){
        return getAllHotelUseCase.getAllHotel();
    }

    @GetMapping ("/{id}")
    public Optional<HotelDTO> getHotelById (@PathVariable Long id){
        return getHotelUseCase.getHotelById(id);
    }

    @PostMapping
    public HotelDTO createHotel (@RequestBody HotelDTO dto) {
        return createHotelUseCase.createHotel(dto);
    }

    @PutMapping ("/partner/update/{id}")
    public Optional<HotelDTO> updateHotel (@RequestBody HotelDTO dto, @PathVariable Long id) {
        return updateHotelUseCase.updateHotelDTO(id,dto);
    }

    @PutMapping("/staff/update/{id}")
    public Optional<HotelDTO> updateStatusHotel (@RequestBody HotelDTO dto, @PathVariable Long id) {
        return updateStatusHotelUseCase.updateStatusHotel(id,dto);
    }

    @DeleteMapping ("/delete/{id}")
    public void deleteHotel (@PathVariable Long id) {
        deleteHotelUseCase.deleteHotel(id);
    }

}
