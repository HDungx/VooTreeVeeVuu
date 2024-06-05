package com.VooTreeVeeVuu.adapters.controller;

import com.VooTreeVeeVuu.adapters.dto.BookingDTO;
import com.VooTreeVeeVuu.usecase.BookingUsecase.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin ("*")
@RestController
@RequestMapping ("/api/bookings")
public class BookingController {
	@Autowired
	private CreateBookingUseCase createBookingUseCase;

	@Autowired
	private UpdateBookingUseCase updateBookingUseCase;

	@Autowired
	private DeleteBookingUseCase deleteBookingUseCase;

	@Autowired
	private GetAllBookingUseCase getAllBookingUseCase;

	@Autowired
	private GetBookingUseCase getBookingUseCase;

	@GetMapping()
	public List<BookingDTO> getAllBooking(){
		return getAllBookingUseCase.getAllBooking();
	}

	@GetMapping ("/{id}")
	public Optional<BookingDTO> getBookingById (@PathVariable String id){
		return getBookingUseCase.getBookingById(id);
	}

	@PostMapping
	public BookingDTO createBooking (@RequestBody BookingDTO dto) {
		return createBookingUseCase.createBookings(dto);
	}

	@PutMapping ("/{id}")
	public Optional<BookingDTO> updateBooking (@RequestBody BookingDTO dto, @PathVariable String id) {
		return updateBookingUseCase.updateBookingDTO(id,dto);
	}

	@DeleteMapping ("/{id}")
	public void deleteBooking (@PathVariable String id) {
		deleteBookingUseCase.deleteBooking(id);
	}

}
