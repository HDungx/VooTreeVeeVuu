package com.VooTreeVeeVuu.usecase.BookingUsecase;

import com.VooTreeVeeVuu.adapters.dto.BookingDTO;
import com.VooTreeVeeVuu.domain.entity.Booking;
import com.VooTreeVeeVuu.domain.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class CreateBookingUseCase {
    @Autowired
    private BookingRepository bookingRepository;

    @Transactional
    public BookingDTO createBookings (BookingDTO bookingDTO){
        Booking bk = toEntity(bookingDTO);
        Booking saved = bookingRepository.save(bk);
        return toDTO(saved);
    }

    private BookingDTO toDTO(Booking booking) {
        BookingDTO dto = new BookingDTO();
        dto.setBookingId(booking.getBookingId());
        dto.setCheckInDate(booking.getCheckInDate());
        dto.setCheckOutDate(booking.getCheckOutDate());
        dto.setTotalPrice(booking.getTotalPrice());
        dto.setBookingDate(booking.getBookingDate());
        dto.setStatus(booking.getStatus());
        return dto;
    }

    private Booking toEntity(BookingDTO bookingDTO) {
        Booking booking = new Booking();
       booking.setBookingId(bookingDTO.getBookingId());
       booking.setCheckInDate(bookingDTO.getCheckInDate());
       booking.setCheckOutDate(bookingDTO.getCheckOutDate());
       booking.setTotalPrice(bookingDTO.getTotalPrice());
       booking.setBookingDate(bookingDTO.getBookingDate());
       booking.setStatus(bookingDTO.getStatus());
        return booking;
    }
}
