package com.VooTreeVeeVuu.adapters.controller;


import com.VooTreeVeeVuu.adapters.dto.RoomDTO;
import com.VooTreeVeeVuu.usecase.RoomUsecase.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin ("*")
@RestController
@RequestMapping ("/api/rooms")
public class RoomController {
    @Autowired
    private CreateRoomUseCase createRoomUseCase;

    @Autowired
    private UpdateRoomUseCase updateRoomUseCase;

    @Autowired
    private DeleteRoomUseCase deleteRoomUseCase;

    @Autowired
    private GetAllRoomUseCase getAllRoomUseCase;

    @Autowired
    private GetRoomUseCase getRoomUseCase;

    @GetMapping ()
    public List<RoomDTO> getAllRoom(){
        return getAllRoomUseCase.getAllRoom();
    }

//    @GetMapping ("/{id}")
//    public Optional<RoomDTO> getRoomById (@PathVariable Long id){
//        return getRoomUseCase.getRoomById(id);
//    }

//    @PostMapping
//    public RoomDTO createRoom(@RequestBody RoomDTO dto) {
//        return createRoomUseCase.createRoom(dto);
//    }

//    @PutMapping ("/update/{id}")
//    public Optional<RoomDTO> updateRoom (@RequestBody RoomDTO dto, @PathVariable Long id) {
//        return updateRoomUseCase.updateRooms(id,dto);
//    }

    @DeleteMapping ("/delete/{id}")
    public void deleteRoom(@PathVariable Long id) {
        deleteRoomUseCase.deleteRoom(id);
    }
}
