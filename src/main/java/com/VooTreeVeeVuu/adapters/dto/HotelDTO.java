package com.VooTreeVeeVuu.adapters.dto;

import com.VooTreeVeeVuu.domain.entity.*;
import com.VooTreeVeeVuu.domain.utils.Hotel_status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelDTO {
    private Long id;
    private String address;
    private String hotelName;
    private String city;
    private String hotelPhoneNum;
    private int hotelStars;
    private String hotelDescription;
    private Hotel_status status;
    private LocalTime checkInTime;
    private LocalTime checkOutTime;
    private Partner partner;
    private HotelImage hotelImages;
    private HotelFacility hotelFacilities;
}
