package com.VooTreeVeeVuu.controller;
import com.VooTreeVeeVuu.entity.RoomImage;
import com.VooTreeVeeVuu.repository.RoomImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/roomImages")
public class RoomImageController {
    @Autowired
    private RoomImageRepository roomImageRepository;


    @GetMapping
    public List<RoomImage> getAllRoomImages() {
        return roomImageRepository.findAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<RoomImage> getRoomImageById(@PathVariable Integer id) {
        Optional<RoomImage> roomImage = roomImageRepository.findById(id);
        if (roomImage.isPresent()) {
            return ResponseEntity.ok(roomImage.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping
    public RoomImage createRoomImage(@RequestBody RoomImage roomImage) {
        return roomImageRepository.save(roomImage);
    }


    @PutMapping ("/update/{id}")
    public ResponseEntity<RoomImage> updateRoomImage(@PathVariable Integer id, @RequestBody RoomImage roomImages) {
        Optional<RoomImage> roomImage = roomImageRepository.findById(id);
        if (roomImage.isPresent()) {
            RoomImage ri = roomImage.get();
            ri.setPath(roomImages.getPath());
            ri.setRoom(roomImages.getRoom());
            RoomImage updatedRoomImage = roomImageRepository.save(ri);
            return ResponseEntity.ok(updatedRoomImage);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<Void> deleteRoomImage(@PathVariable Integer id) {
        Optional<RoomImage> roomImage = roomImageRepository.findById(id);
        if (roomImage.isPresent()) {
            roomImageRepository.delete(roomImage.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
