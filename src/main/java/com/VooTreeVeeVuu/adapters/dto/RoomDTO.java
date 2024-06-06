package com.VooTreeVeeVuu.adapters.dto;

import com.VooTreeVeeVuu.domain.entity.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomDTO {
	private Long id;
	private int capacity;
	private double price;
	private Integer quantity;
	private double roomSize;
	private String description;
	private RoomType roomType;
	private Hotel hotel;
	private List<RoomFacility> roomFacilities;
	private List<Booking> listBooking;
	private List<RoomImage> room_images;
}