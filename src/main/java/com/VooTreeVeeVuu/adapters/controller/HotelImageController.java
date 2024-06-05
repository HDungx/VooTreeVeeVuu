package com.VooTreeVeeVuu.adapters.controller;
import com.VooTreeVeeVuu.domain.entity.HotelImage;
import com.VooTreeVeeVuu.domain.repository.HotelImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/hotelImages")
public class HotelImageController {
    @Autowired
    private HotelImageRepository hotelImageRepository;

    @GetMapping
    public List<HotelImage> getAllHotelImages() {
        return hotelImageRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<HotelImage> getHotelImageById(@PathVariable Integer id) {
        Optional<HotelImage> hotelImage = hotelImageRepository.findById(id);
        if (hotelImage.isPresent()) {
            return ResponseEntity.ok(hotelImage.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping
    public HotelImage createHotelImage(@RequestBody HotelImage hotelImage) {
        return hotelImageRepository.save(hotelImage);
    }


    @PutMapping ("/update/{id}")
    public ResponseEntity<HotelImage> updateHotelImage(@PathVariable Integer id, @RequestBody HotelImage hotelImages) {
        Optional<HotelImage> hotelImage = hotelImageRepository.findById(id);
        if (hotelImage.isPresent()) {
            HotelImage hi = hotelImage.get();
            hi.setPath(hotelImages.getPath());
            hi.setHotel(hotelImages.getHotel());
            HotelImage updatedHotelImage = hotelImageRepository.save(hi);
            return ResponseEntity.ok(updatedHotelImage);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<Void> deleteHotelImage(@PathVariable Integer id) {
        Optional<HotelImage> hotelImage = hotelImageRepository.findById(id);
        if (hotelImage.isPresent()) {
            hotelImageRepository.delete(hotelImage.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
