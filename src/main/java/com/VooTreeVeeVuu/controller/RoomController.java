package com.VooTreeVeeVuu.controller;


import com.VooTreeVeeVuu.dto.GetAllRoomDTO;
import com.VooTreeVeeVuu.usecase.RoomUsecase.DeleteRoom.DeleteRoomImpl;
import com.VooTreeVeeVuu.usecase.RoomUsecase.GetAllRoom.GetAllRoomImpl;
import com.VooTreeVeeVuu.usecase.RoomUsecase.GetRoom.GetRoomImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/rooms")
public class RoomController {
    @Autowired
    private DeleteRoomImpl deleteRoomUseCase;

    @Autowired
    private GetAllRoomImpl getAllRoomUseCase;

    @Autowired
    private GetRoomImpl getRoomUseCase;

    @GetMapping()
    public List<GetAllRoomDTO> getAllRoom() {
        return getAllRoomUseCase.getAllRoom();
    }

    @GetMapping("/{id}")
    public Optional<GetAllRoomDTO> getRoomById(@PathVariable Long id) {
        return getRoomUseCase.getRoomById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteRoom(@PathVariable Long id) {
        deleteRoomUseCase.deleteRoom(id);
    }
}
