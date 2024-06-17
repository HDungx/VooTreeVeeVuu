package com.VooTreeVeeVuu.controller;


import com.VooTreeVeeVuu.dto.GetAllRoomDTO;
import com.VooTreeVeeVuu.usecase.RoomUsecase.DeleteRoomUseCase;
import com.VooTreeVeeVuu.usecase.RoomUsecase.GetAllRoomUseCase;
import com.VooTreeVeeVuu.usecase.RoomUsecase.GetRoomUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/rooms")
public class RoomController {
    @Autowired
    private DeleteRoomUseCase deleteRoomUseCase;

    @Autowired
    private GetAllRoomUseCase getAllRoomUseCase;

    @Autowired
    private GetRoomUseCase getRoomUseCase;

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
