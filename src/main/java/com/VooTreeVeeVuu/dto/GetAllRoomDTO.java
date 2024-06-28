package com.VooTreeVeeVuu.dto;

import com.VooTreeVeeVuu.domain.entity.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllRoomDTO {
    private Long id;
    private int capacity;
    private double price;
    private Integer quantity;
    private double roomSize;
    private String description;
    private RoomType roomType;
    private boolean serveBreakfast;
    private Hotel hotel;
    private String ownerEmail;
    private List<RoomFacility> roomFacilities;
    private List<Booking> listBooking;
    private List<RoomImageDTO> room_images;
}
