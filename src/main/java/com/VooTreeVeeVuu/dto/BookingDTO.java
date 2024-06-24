package com.VooTreeVeeVuu.dto;

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
    private String userName; // Tên người đặt, tách biệt để dễ dàng hiển thị
    private String hotelName; // Tên khách sạn
    private String roomType; // Loại phòng
    private String address; // Địa chỉ khách sạn
    private String city;
    private Long hotelOwnerId;
    private Booking_status status;
    private Integer numOfRoom;
    private Integer numOfGuest;
    private LocalDate bookingDate;

}
