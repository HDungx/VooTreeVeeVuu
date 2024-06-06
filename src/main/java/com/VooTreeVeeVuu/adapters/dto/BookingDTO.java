package com.VooTreeVeeVuu.adapters.dto;

import com.VooTreeVeeVuu.domain.entity.Room;
import com.VooTreeVeeVuu.domain.entity.User;
import com.VooTreeVeeVuu.domain.utils.Booking_status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingDTO {
    private Long id;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private double totalPrice;
    private User user;
    private Room room;
    private LocalDate bookingDate;
    private Booking_status status;
    private Integer numOfRoom;
    private Integer numOfGuest;

}
