package com.VooTreeVeeVuu.usecase.BookingUsecase.CreateBooking;

import com.VooTreeVeeVuu.dto.BookingDTO;
import com.VooTreeVeeVuu.domain.entity.Booking;
import com.VooTreeVeeVuu.domain.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreateBookingImpl implements CreateBooking {
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
        dto.setId(booking.getId());
        dto.setCheckInDate(booking.getCheckInDate());
        dto.setCheckOutDate(booking.getCheckOutDate());
        dto.setTotalPrice(booking.getTotalPrice());
        dto.setBookingDate(booking.getBookingDate());
        dto.setStatus(booking.getStatus());
        dto.setNumOfRoom(booking.getNumOfRoom());
        dto.setNumOfGuest(booking.getNumOfGuest());
        return dto;
    }

    private Booking toEntity(BookingDTO bookingDTO) {
        Booking booking = new Booking();
        booking.setId(bookingDTO.getId());
        booking.setCheckInDate(bookingDTO.getCheckInDate());
        booking.setCheckOutDate(bookingDTO.getCheckOutDate());
        booking.setTotalPrice(bookingDTO.getTotalPrice());
        booking.setBookingDate(bookingDTO.getBookingDate());
        booking.setStatus(bookingDTO.getStatus());
        booking.setNumOfRoom(bookingDTO.getNumOfRoom());
        booking.setNumOfGuest(bookingDTO.getNumOfGuest());
        return booking;
    }
}
