package com.VooTreeVeeVuu.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailReceiptDTO {
    private String hotelName;
    private String roomType;
    private String address;
    private String cusEmail;
    private String hotelPhoneNum;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private LocalTime checkInTime;
    private LocalTime checkOutTime;
    private Integer num_of_rooms;
    private Integer num_of_guests;
    private Long totalPrice;

}
