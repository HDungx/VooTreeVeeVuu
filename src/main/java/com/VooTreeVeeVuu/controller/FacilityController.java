package com.VooTreeVeeVuu.controller;


import com.VooTreeVeeVuu.entity.Facility;
import com.VooTreeVeeVuu.repository.FacilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/facilities")
public class FacilityController {
    @Autowired
    private FacilityRepository facilityRepository;

    @GetMapping
    public List<Facility> getAllFacilities() {
        return facilityRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Facility> getFacilityById(@PathVariable Integer id) {
        Optional<Facility> facility = facilityRepository.findById(id);
        if (facility.isPresent()) {
            return ResponseEntity.ok(facility.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Facility createFacility(@RequestBody Facility facility) {
        return facilityRepository.save(facility);
    }

    @PutMapping ("/update/{id}")
    public ResponseEntity<Facility> updateFacility(@PathVariable Integer id, @RequestBody Facility facilities) {
        Optional<Facility> facility = facilityRepository.findById(id);
        if (facility.isPresent()) {
            Facility fc = facility.get();
            fc.setFacType(facilities.getFacType());
            fc.setFacName(facilities.getFacName());
            Facility updatedFacility = facilityRepository.save(fc);
            return ResponseEntity.ok(updatedFacility);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    // Delete a facility
    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<Void> deleteFacility(@PathVariable Integer id) {
        Optional<Facility> facility = facilityRepository.findById(id);
        if (facility.isPresent()) {
            facilityRepository.delete(facility.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
