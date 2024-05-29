package com.VooTreeVeeVuu.controller;

import com.VooTreeVeeVuu.entity.Booking;
import com.VooTreeVeeVuu.servicesImp.BookingServImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin ("*")
@RestController
@RequestMapping ("/api/bookings")
public class BookingController {
	@Autowired
	BookingServImp bookingServImp;

	@GetMapping ()
	public ResponseEntity<List<Booking>> getAllBooking () {
		return new ResponseEntity<>(bookingServImp.getAll(), HttpStatus.OK);
	}

	@GetMapping ("/{id}")
	public ResponseEntity<Booking> getBookingById (@PathVariable String id) {
		return bookingServImp.getById(id).map(bk -> new ResponseEntity<>(bk, HttpStatus.OK)).orElse(
				new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@PostMapping
	public ResponseEntity<Booking> createBooking (@RequestBody Booking booking) {
		return new ResponseEntity<>(bookingServImp.save(booking), HttpStatus.CREATED);
	}

	@PutMapping ("/{id}")
	public ResponseEntity<Booking> updateBooking (@RequestBody Booking booking, @PathVariable String id) {
		return bookingServImp.getById(id).map(bk -> {
			bk.setStatus(booking.getStatus());
			return new ResponseEntity<>(bookingServImp.save(bk), HttpStatus.OK);
		}).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteBooking (@PathVariable String id){
		return bookingServImp.getById(id).map(bk -> {
			bookingServImp.delete(id);
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
}
