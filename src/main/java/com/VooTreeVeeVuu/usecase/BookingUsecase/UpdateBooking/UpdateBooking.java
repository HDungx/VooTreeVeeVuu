package com.VooTreeVeeVuu.usecase.BookingUsecase.UpdateBooking;

import com.VooTreeVeeVuu.dto.BookingDTO;

import java.util.Optional;

public interface UpdateBooking {
	Optional<BookingDTO> updateBookingDTO(Long id, BookingDTO bookingDTO);
}
