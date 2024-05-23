package com.VooTreeVeeVuu.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Rooms")
public class Room {
	@Id
	String roomId;

	int capacity;
	double price;
	int quantity;
	int room_size;
	String description;
	@ManyToOne @JoinColumn(name ="type_id")
	RoomType roomType;
	@ManyToOne @JoinColumn(name = "hotel_id")
	Hotel hotel;
	@JsonIgnore
	@OneToMany (mappedBy = "room")
	List<RoomFacility> room_Facilities;
	@JsonIgnore
	@OneToMany (mappedBy ="room")
	List<Booking> listBooking;
	@OneToMany (mappedBy = "room")
	List<RoomImage> room_images;
}
