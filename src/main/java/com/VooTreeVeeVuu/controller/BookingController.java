package com.VooTreeVeeVuu.controller;

import com.VooTreeVeeVuu.dto.BookingDTO;
import com.VooTreeVeeVuu.services.BookingService;
import com.VooTreeVeeVuu.usecase.BookingUsecase.GetAllBooking.GetAllBookingImpl;
import com.VooTreeVeeVuu.usecase.BookingUsecase.GetBooking.GetBookingImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/bookings")
public class BookingController {
    @Autowired
    private GetAllBookingImpl getAllBookingUseCase;

    @Autowired
    private GetBookingImpl getBookingUseCase;

    @Autowired
    private BookingService bookingService;

    @GetMapping()
    public List<BookingDTO> getAllBooking() {
        return getAllBookingUseCase.getAllBooking();
    }

    @GetMapping("/{id}")
    public Optional<BookingDTO> getBookingById(@PathVariable Long id) {
        return getBookingUseCase.getBookingById(id);
    }

	@PostMapping
	public BookingDTO createBooking (@RequestBody BookingDTO dto) {
		return createBookingUseCase.createBookings(dto);
	}

	@PutMapping ("/update/{id}")
	public Optional<BookingDTO> updateBooking (@RequestBody BookingDTO dto, @PathVariable Long id) {
		return updateBookingUseCase.updateBookingDTO(id,dto);
	}

	@DeleteMapping ("/delete/{id}")
	public void deleteBooking (@PathVariable Long id) {
		deleteBookingUseCase.deleteBooking(id);
	}

}
