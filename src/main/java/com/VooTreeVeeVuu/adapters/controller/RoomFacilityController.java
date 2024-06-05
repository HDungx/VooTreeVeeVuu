package com.VooTreeVeeVuu.adapters.controller;
import com.VooTreeVeeVuu.domain.entity.RoomFacility;
import com.VooTreeVeeVuu.domain.repository.RoomFacilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/roomFacilities")
public class RoomFacilityController {
//    @Autowired
//    private RoomFacilityRepository roomFacilityRepository;
//
//    @GetMapping
//    public List<RoomFacility> getAllRoomFacilities() {
//        return roomFacilityRepository.findAll();
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<RoomFacility> getRoomFacilityById(@PathVariable Integer id) {
//        Optional<RoomFacility> roomFacility = roomFacilityRepository.findById(id);
//        if (roomFacility.isPresent()) {
//            return ResponseEntity.ok(roomFacility.get());
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @PostMapping
//    public RoomFacility createRoomFacility(@RequestBody RoomFacility roomFacility) {
//        return roomFacilityRepository.save(roomFacility);
//    }
//
//    @PutMapping ("/update/{id}")
//    public ResponseEntity<RoomFacility> updateRoomFacility(@PathVariable Integer id, @RequestBody RoomFacility roomFacilities) {
//        Optional<RoomFacility> roomFacility = roomFacilityRepository.findById(id);
//        if (roomFacility.isPresent()) {
//            RoomFacility rf = roomFacility.get();
//            rf.setRoom(roomFacilities.getRoom());
//            rf.setFacility(roomFacilities.getFacility());
//            RoomFacility updatedRoomFacility = roomFacilityRepository.save(rf);
//            return ResponseEntity.ok(updatedRoomFacility);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @DeleteMapping ("/delete/{id}")
//    public ResponseEntity<Void> deleteRoomFacility(@PathVariable Integer id) {
//        Optional<RoomFacility> roomFacility = roomFacilityRepository.findById(id);
//        if (roomFacility.isPresent()) {
//            roomFacilityRepository.delete(roomFacility.get());
//            return ResponseEntity.noContent().build();
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
}
