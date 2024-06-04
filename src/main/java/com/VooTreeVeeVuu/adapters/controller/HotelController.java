package com.VooTreeVeeVuu.adapters.controller;

import com.VooTreeVeeVuu.domain.entity.Hotel;
import com.VooTreeVeeVuu.servicesImp.HotelServImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin ("*")
@RestController
@RequestMapping ("/api/hotels")
public class HotelController {
	@Autowired
	HotelServImp hotelServImp;

//	@GetMapping ()
//	public Page<Hotel> getAllHotel (@RequestParam (defaultValue = "0") int page,
//	                                @RequestParam (defaultValue = "10") int size,
//	                                @RequestParam (defaultValue = "hotelId") String sortBy,
//	                                @RequestParam (defaultValue = "asc") String dir) {
//		Sort sort = dir.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
//		Pageable pageable = PageRequest.of(page, size, sort);
//		return hotelServImp.getAll(pageable);
//	}

	@GetMapping ()
	public ResponseEntity<List<Hotel>> getAllHotels () {
		return new ResponseEntity<>(hotelServImp.getAll(), HttpStatus.OK);
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

	@PutMapping ("/update/{id}")
	public ResponseEntity<Hotel> updateHotel (@RequestBody Hotel hotel, @PathVariable String id) {
		return hotelServImp.getById(id).map(h -> {
			h.setAddress(hotel.getAddress());
			h.setCity(hotel.getCity());
			h.setHotelPhoneNum(hotel.getHotelPhoneNum());
			h.setHotelStars(hotel.getHotelStars());
			h.setHotelDescription(hotel.getHotelDescription());
			h.setStatus(Hotel.Hotel_status.PENDING);
			h.setCheckInTime(hotel.getCheckInTime());
			h.setCheckOutTime(hotel.getCheckOutTime());
			h.setAccommodationType(hotel.getAccommodationType());
			h.setPartner(hotel.getPartner());
			return new ResponseEntity<>(hotelServImp.save(h), HttpStatus.OK);
		}).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@PutMapping ("/admin/update/{id}")
	public ResponseEntity<Hotel> updateStatusHotel (@RequestBody Hotel hotel, @PathVariable String id) {
		return hotelServImp.getById(id).map(h -> {
			h.setStatus(hotel.getStatus());
			return new ResponseEntity<>(hotelServImp.save(h), HttpStatus.OK);
		}).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@DeleteMapping ("/delete/{id}")
	public ResponseEntity<Void> deleteHotel (@PathVariable String id) {
		return hotelServImp.getById(id).map(h -> {
			hotelServImp.delete(id);
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
}
