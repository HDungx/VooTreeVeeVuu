package com.VooTreeVeeVuu.usecase.BookingUsecase;

import com.VooTreeVeeVuu.adapters.dto.BookingDTO;
import com.VooTreeVeeVuu.domain.entity.Booking;
import com.VooTreeVeeVuu.domain.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public class UpdateBookingUseCase {
    @Autowired
    private BookingRepository bookingRepository;

    @Transactional
    public Optional<BookingDTO> updateBookingDTO(String id, BookingDTO bookingDTO){
        return bookingRepository.findById(id).map(booking -> {
            booking.setCheckInDate(bookingDTO.getCheckInDate());
            booking.setCheckOutDate(bookingDTO.getCheckOutDate());
            booking.setBookingDate(bookingDTO.getBookingDate());
            booking.setTotalPrice(bookingDTO.getTotalPrice());
            booking.setStatus(bookingDTO.getStatus());
            Booking updated = bookingRepository.save(booking);
            return toDTO(updated);
        });
    }

    private BookingDTO toDTO(Booking booking) {
        BookingDTO dto = new BookingDTO();
       dto.setBookingDate(booking.getBookingDate());
       dto.setCheckInDate(booking.getCheckInDate());
       dto.setCheckOutDate(booking.getCheckOutDate());
       dto.setTotalPrice(booking.getTotalPrice());
       dto.setStatus(booking.getStatus());
        return dto;
    }
}
