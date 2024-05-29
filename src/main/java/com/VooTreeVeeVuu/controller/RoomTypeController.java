package com.VooTreeVeeVuu.controller;
import com.VooTreeVeeVuu.entity.RoomType;
import com.VooTreeVeeVuu.repository.RoomTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/roomTypes")
public class RoomTypeController {
    @Autowired
    private RoomTypeRepository roomTypeRepository;

    @GetMapping
    public List<RoomType> getAllRoomTypes() {
        return roomTypeRepository.findAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<RoomType> getRoomTypeById(@PathVariable String id) {
        Optional<RoomType> roomType = roomTypeRepository.findById(id);
        if (roomType.isPresent()) {
            return ResponseEntity.ok(roomType.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public RoomType createRoomType(@RequestBody RoomType roomType) {
        return roomTypeRepository.save(roomType);
    }


    @PutMapping ("/update/{id}")
    public ResponseEntity<RoomType> updateRoomType(@PathVariable String id, @RequestBody RoomType roomTypes) {
        Optional<RoomType> roomType = roomTypeRepository.findById(id);
        if (roomType.isPresent()) {
            RoomType rt = roomType.get();
            rt.setTypeName(roomTypes.getTypeName());
            RoomType updatedRoomType = roomTypeRepository.save(rt);
            return ResponseEntity.ok(updatedRoomType);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<Void> deleteRoomType(@PathVariable String id) {
        Optional<RoomType> roomType = roomTypeRepository.findById(id);
        if (roomType.isPresent()) {
            roomTypeRepository.delete(roomType.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }



}
