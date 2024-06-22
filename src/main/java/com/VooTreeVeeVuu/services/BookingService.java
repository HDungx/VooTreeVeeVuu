package com.VooTreeVeeVuu.services;

import com.VooTreeVeeVuu.domain.entity.Booking;
import com.VooTreeVeeVuu.domain.entity.Room;
import com.VooTreeVeeVuu.domain.entity.User;
import com.VooTreeVeeVuu.domain.repository.BookingRepository;
import com.VooTreeVeeVuu.domain.repository.RoomRepository;
import com.VooTreeVeeVuu.domain.repository.UserRepository;
import com.VooTreeVeeVuu.domain.utils.Booking_status;
import com.VooTreeVeeVuu.dto.BookingDTO;
import com.VooTreeVeeVuu.dto.InsertBookingDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoomRepository roomRepository;

    public Booking createBooking(InsertBookingDTO bookingDTO) {
        User customer = userRepository.findById(bookingDTO.getUserId()).orElseThrow(() -> new RuntimeException("Customer not found"));

        Room room = roomRepository.findById(bookingDTO.getUserId()).orElseThrow(() -> new RuntimeException("Room not found"));

//        boolean isAvailable = true;
//        List<Booking> list = bookingRepository.findAll();
//
//        for (Booking booking : list) {
//            if (booking.getRoom().getId().equals(bookingDTO.getRoomId()) && booking.getRoom().getQuantity() > 0) {
//
//            }
//        }
//        if (!isAvailable) {
//            throw new RuntimeException("Room is not available at given dates");
//      }

        Booking booking = new Booking();
        booking.setUser(customer);
        booking.setRoom(room);
        booking.setBookingDate(LocalDate.now());
        booking.setStatus(Booking_status.PENDING);
        booking.setCheckInDate(bookingDTO.getCheck_in_date());
        booking.setCheckOutDate(bookingDTO.getCheck_out_date());
        booking.setNumOfGuest(bookingDTO.getNum_of_guest());
        booking.setNumOfRoom(bookingDTO.getNum_of_rooms());
        booking.setTotalPrice(bookingDTO.getTotal_price());

        return bookingRepository.save(booking);
    }

    public List<BookingDTO> getUserBookingHistory(Long userId) {
        return bookingRepository.findBookingHistoryByUser(userId).stream().map(this::toDTO).collect(Collectors.toList());
    }

    private BookingDTO toDTO(Booking booking) {
        BookingDTO dto = new BookingDTO();
        dto.setId(booking.getId());
        dto.setCheckInDate(booking.getCheckInDate());
        dto.setCheckOutDate(booking.getCheckOutDate());
        dto.setTotalPrice(booking.getTotalPrice());
        dto.setUserName(booking.getUser().getAccount().getUsername());
        dto.setHotelName(booking.getRoom().getHotel().getHotelName());
        dto.setRoomType(booking.getRoom().getRoomType().getTypeName());
        dto.setAddress(booking.getRoom().getHotel().getAddress());
        dto.setStatus(booking.getStatus());
        dto.setNumOfRoom(booking.getNumOfRoom());
        dto.setNumOfGuest(booking.getNumOfGuest());
        dto.setBookingDate(booking.getBookingDate());
        return dto;
    }
}
