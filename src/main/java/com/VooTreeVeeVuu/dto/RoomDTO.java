package com.VooTreeVeeVuu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomDTO {
    //private Long id;
    private int capacity;
    private double price;
    private Integer quantity;
    private double roomSize;
    private String description;
    private Long roomTypeId;
    private boolean serveBreakfast;
    //   private Long hotelId;
    private List<RoomFacilityDTO> roomFacilities;
    //private List<Booking> listBooking;
    //private List<RoomImage> room_images;
}
