package com.VooTreeVeeVuu.adapters.dto;

import com.VooTreeVeeVuu.domain.entity.Customer;
import com.VooTreeVeeVuu.domain.entity.Room;
import com.VooTreeVeeVuu.utils.Booking_status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingDTO {
private String bookingId;
private LocalDate checkInDate;
private LocalDate checkOutDate;
private double totalPrice;
private Customer customer;
private Room room;
private LocalDate bookingDate;
private Booking_status status;

}
