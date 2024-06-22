package com.VooTreeVeeVuu.dto;

import com.VooTreeVeeVuu.domain.utils.Booking_status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InsertBookingDTO {
    private LocalDate check_in_date;
    private LocalDate check_out_date;
    private int num_of_guest;
    private int num_of_rooms;
    private Booking_status status;
    private double total_price;
    private Long roomId;
    private Long userId;
}
