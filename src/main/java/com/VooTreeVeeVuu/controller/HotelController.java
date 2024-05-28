package com.VooTreeVeeVuu.controller;

import com.VooTreeVeeVuu.entity.Hotel;
import com.VooTreeVeeVuu.servicesImp.HotelServImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin ("*")
@RestController
@RequestMapping ("/api/hotels")
public class HotelController {
	@Autowired
	HotelServImp hotelServImp;

	@GetMapping ()
	public Page<Hotel> getAllHotel (@RequestParam (defaultValue = "0") int page,
	                                @RequestParam (defaultValue = "10") int size,
	                                @RequestParam (defaultValue = "hotelId") String sortBy,
	                                @RequestParam (defaultValue = "asc") String dir) {
		Sort sort = dir.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
		Pageable pageable = PageRequest.of(page, size, sort);
		return hotelServImp.getAll(pageable);
	}

	@GetMapping ("/{id}")
	public ResponseEntity<Hotel> getHotelById (@PathVariable String id) {
		Optional<Hotel> hotel = hotelServImp.getById(id);
		return hotel.map(ResponseEntity :: ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<Hotel> createHotel (@RequestBody Hotel hotel) {
		return new ResponseEntity<>(hotelServImp.save(hotel), HttpStatus.CREATED);
	}

	@PutMapping ("/{id}")
	public ResponseEntity<Hotel> updateHotel (@RequestBody Hotel hotel, @PathVariable String id) {
		return hotelServImp.getById(id).map(h -> {
			h.setAddress(hotel.getAddress());
			h.setCity(hotel.getCity());
			h.setHotelPhoneNum(hotel.getHotelPhoneNum());
			h.setHotelStars(hotel.getHotelStars());
			h.setHotelDescription(hotel.getHotelDescription());
			h.setStatus(hotel.getStatus());
			h.setCheckInTime(hotel.getCheckInTime());
			h.setCheckOutTime(hotel.getCheckOutTime());
			h.setAccommodationType(hotel.getAccommodationType());
			h.setPartner(hotel.getPartner());
			return new ResponseEntity<>(hotelServImp.save(h), HttpStatus.OK);
		}).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@DeleteMapping ("/{id}")
	public ResponseEntity<Void> deleteHotel (@PathVariable String id) {
		return hotelServImp.getById(id).map(h -> {
			hotelServImp.delete(id);
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
}
