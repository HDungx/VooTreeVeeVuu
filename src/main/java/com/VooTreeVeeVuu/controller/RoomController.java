package com.VooTreeVeeVuu.controller;


import com.VooTreeVeeVuu.dto.GetAllRoomDTO;
import com.VooTreeVeeVuu.dto.RoomDTO;
import com.VooTreeVeeVuu.services.RoomService;
import com.VooTreeVeeVuu.usecase.RoomUsecase.CreateRoom.CreateRoom;
import com.VooTreeVeeVuu.usecase.RoomUsecase.DeleteRoom.DeleteRoomImpl;
import com.VooTreeVeeVuu.usecase.RoomUsecase.GetAllRoom.GetAllRoomImpl;
import com.VooTreeVeeVuu.usecase.RoomUsecase.GetRoom.GetRoomImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @Autowired
    private RoomService roomService;

    @Autowired
    private CreateRoom createRoom;

    @GetMapping()
    public List<GetAllRoomDTO> getAllRoom() {
        return getAllRoomUseCase.getAllRoom();
    }

    @GetMapping("/{id}")
    public Optional<GetAllRoomDTO> getRoomById(@PathVariable Long id) {
        return Optional.ofNullable(getRoomUseCase.getRoomById(id));
    }

    @PostMapping("/partner/create/{hotelId}")
    public ResponseEntity<RoomDTO> createRoom(@PathVariable("hotelId") Long hotelId, @RequestBody RoomDTO roomDTO) {
        RoomDTO createdRoom = createRoom.createRoom(hotelId, roomDTO);
        return new ResponseEntity<>(createdRoom, HttpStatus.CREATED);
    }

    @PutMapping("/partner/update/{id}")
    public ResponseEntity<RoomDTO> updateRoom(@PathVariable Long id, @RequestBody RoomDTO roomDTO) {
        RoomDTO updatedRoom = roomService.updateRooms(id, roomDTO);
        return ResponseEntity.ok(updatedRoom);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteRoom(@PathVariable Long id) {
        deleteRoomUseCase.deleteRoom(id);
    }
}
