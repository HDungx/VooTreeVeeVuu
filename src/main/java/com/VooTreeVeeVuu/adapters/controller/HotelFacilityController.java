package com.VooTreeVeeVuu.adapters.controller;

import com.VooTreeVeeVuu.domain.entity.HotelFacility;
import com.VooTreeVeeVuu.domain.repository.HotelFacilityRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/hotelFacilities")
public class HotelFacilityController {
    @Autowired
    private HotelFacilityRepository hotelFacilityRepository;

    @GetMapping
    public List<HotelFacility> getAllHotelFacilities() {
        return hotelFacilityRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<HotelFacility> getHotelFacilityById(@PathVariable Integer id) {
        Optional<HotelFacility> hotelFacility = hotelFacilityRepository.findById(id);
        if (hotelFacility.isPresent()) {
            return ResponseEntity.ok(hotelFacility.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public HotelFacility createHotelFacility(@RequestBody HotelFacility hotelFacility) {
        return hotelFacilityRepository.save(hotelFacility);
    }

    @PutMapping ("/update/{id}")
    public ResponseEntity<HotelFacility> updateHotelFacility(@PathVariable Integer id, @RequestBody HotelFacility hotelFacilities) {
        Optional<HotelFacility> hotelFacility = hotelFacilityRepository.findById(id);
        if (hotelFacility.isPresent()) {
            HotelFacility htf = hotelFacility.get();
            htf.setFacility(hotelFacilities.getFacility());
            htf.setHotel(hotelFacilities.getHotel());
            HotelFacility updatedHotelFacility = hotelFacilityRepository.save(htf);
            return ResponseEntity.ok(updatedHotelFacility);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<Void> deleteHotelFacility(@PathVariable Integer id) {
        Optional<HotelFacility> hotelFacility = hotelFacilityRepository.findById(id);
        if (hotelFacility.isPresent()) {
            hotelFacilityRepository.delete(hotelFacility.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
