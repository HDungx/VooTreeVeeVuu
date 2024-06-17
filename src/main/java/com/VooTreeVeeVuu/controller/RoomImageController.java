package com.VooTreeVeeVuu.controller;

import com.VooTreeVeeVuu.dto.RoomImageDTO;
import com.VooTreeVeeVuu.usecase.RoomImageUsecase.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/roomImages")
public class RoomImageController {
    @Autowired
    private CreateRoomImageUseCase createRoomImageUseCase;

    @Autowired
    private UpdateRoomImageUseCase updateRoomImageUseCase;

    @Autowired
    private DeleteRoomImageUseCase deleteRoomImageUseCase;

    @Autowired
    private GetAllRoomImageUseCase getAllRoomImageUseCase;

    @Autowired
    private GetRoomImageUseCase  getRoomImageUseCase;

    @GetMapping ()
    public List<RoomImageDTO> getAllRoomImages(){
        return getAllRoomImageUseCase.getAllRoomImage();
    }

    @GetMapping ("/{id}")
    public Optional<RoomImageDTO> getRoomImageById (@PathVariable Long id){
        return getRoomImageUseCase.getRoomImageById(id);
    }

    @PostMapping
    public RoomImageDTO createRoomImage(@RequestBody RoomImageDTO dto) {
        return createRoomImageUseCase.createRoomImage(dto);
    }

    @PutMapping ("/update/{id}")
    public Optional<RoomImageDTO> updateRoomImage (@RequestBody RoomImageDTO dto, @PathVariable Long id) {
        return updateRoomImageUseCase.updateRoomImage(id,dto);
    }

    @DeleteMapping ("/delete/{id}")
    public void deleteRoomImage(@PathVariable Long id) {
       deleteRoomImageUseCase.deleteRoomImage(id);
    }

}
