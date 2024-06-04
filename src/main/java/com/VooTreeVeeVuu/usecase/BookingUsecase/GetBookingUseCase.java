package com.VooTreeVeeVuu.usecase.BookingUsecase;

import com.VooTreeVeeVuu.adapters.dto.BookingDTO;
import com.VooTreeVeeVuu.domain.entity.Booking;
import com.VooTreeVeeVuu.domain.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class GetBookingUseCase {
    @Autowired
    private BookingRepository bookingRepository;

    public Optional<BookingDTO> getBookingById(String id){
        return bookingRepository.findById(id).map(this :: toDTO);
    }

    private BookingDTO toDTO(Booking booking) {
        BookingDTO dto = new BookingDTO();
        dto.setBookingId(booking.getBookingId());
        dto.setBookingDate(booking.getBookingDate());
        dto.setCheckInDate(booking.getCheckInDate());
        dto.setCheckOutDate(booking.getCheckOutDate());
        dto.setTotalPrice(booking.getTotalPrice());
        dto.setStatus(booking.getStatus());
        return dto;
    }
}
