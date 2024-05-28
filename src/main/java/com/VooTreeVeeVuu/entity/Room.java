package com.VooTreeVeeVuu.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.NumberFormat;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "Rooms")
public class Room {
	@Id
	String roomId;
	@NotNull
	@Min (1)
	@Max (8)
	int capacity;
	@NotNull
	@NumberFormat (style = NumberFormat.Style.CURRENCY)
	double price;
	@NotNull
	@Min (1)
	int quantity;
	@NotNull
	@NumberFormat (style = NumberFormat.Style.NUMBER)
	double roomSize;
	@NotBlank
	@Column (columnDefinition = "nvarchar(255)")
	String description;
	@ManyToOne
	@JoinColumn (name = "type_id")
	RoomType roomType;
	@ManyToOne
	@JoinColumn (name = "hotel_id")
	Hotel hotel;
	@JsonIgnore
	@OneToMany (mappedBy = "room")
	List<RoomFacility> roomFacilities;
	@JsonIgnore
	@OneToMany (mappedBy = "room")
	List<Booking> listBooking;
	@OneToMany (mappedBy = "room")
	List<RoomImage> room_images;
}
