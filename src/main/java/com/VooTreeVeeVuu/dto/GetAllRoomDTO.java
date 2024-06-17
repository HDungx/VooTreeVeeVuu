package com.VooTreeVeeVuu.dto;

import com.VooTreeVeeVuu.domain.entity.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.NumberFormat;

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
	private boolean serveBreakfast;
	private RoomType roomType;
	private Hotel hotel;
	private List<RoomFacility> roomFacilities;
	//private List<Booking> listBooking;
	private List<RoomImage> room_images;
}
