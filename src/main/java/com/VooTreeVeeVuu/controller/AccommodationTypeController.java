package com.VooTreeVeeVuu.controller;
import com.VooTreeVeeVuu.entity.AccommodationType;
import com.VooTreeVeeVuu.repository.AccommodationTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/accommodationTypes")
public class AccommodationTypeController {

    @Autowired
    private AccommodationTypeRepository accommodationTypeRepository;


    @GetMapping
    public List<AccommodationType> getAllAccommodationTypes() {
        return accommodationTypeRepository.findAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<AccommodationType> getAccommodationTypeById(@PathVariable String id) {
        Optional<AccommodationType> accommodationType = accommodationTypeRepository.findById(id);
        if (accommodationType.isPresent()) {
            return ResponseEntity.ok(accommodationType.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping
    public AccommodationType createAccommodationType(@RequestBody AccommodationType accommodationType) {
        return accommodationTypeRepository.save(accommodationType);
    }


    @PutMapping("/{id}")
    public ResponseEntity<AccommodationType> updateAccommodationType(@PathVariable String id, @RequestBody AccommodationType accommodationTypes) {
        Optional<AccommodationType> accommodationType = accommodationTypeRepository.findById(id);
        if (accommodationType.isPresent()) {
            AccommodationType act = accommodationType.get();
            act.setTypeName(accommodationTypes.getTypeName());
            AccommodationType updatedAccommodationType = accommodationTypeRepository.save(act);
            return ResponseEntity.ok(updatedAccommodationType);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccommodationType(@PathVariable String id) {
        Optional<AccommodationType> accommodationType = accommodationTypeRepository.findById(id);
        if (accommodationType.isPresent()) {
            accommodationTypeRepository.delete(accommodationType.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
