package com.VooTreeVeeVuu.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.NumberFormat;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "Rooms")
public class Room {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@Min (1)
	@Max (8)
	private int capacity;
	@NotNull
	@NumberFormat (style = NumberFormat.Style.CURRENCY)
	private double price;
	@NotNull
	@Min (1)
	private Integer quantity;
	@NotNull
	@NumberFormat (style = NumberFormat.Style.NUMBER)
	private double roomSize;
	@NotBlank
	@Column (columnDefinition = "nvarchar(255)", name = "description")
	private String description;
	//@JsonIgnored
	@ManyToOne
	@JoinColumn (name = "typeId")
	RoomType roomType;
	//@JsonIgnored
	@ManyToOne
	@JoinColumn (name = "hotelId")
	Hotel hotel;
	@JsonIgnore
	@OneToMany (mappedBy = "room")
	List<RoomFacility> roomFacilities;
	@JsonIgnore
	@OneToMany (mappedBy = "room")
	List<Booking> listBooking;
	//@JsonIgnored
	@OneToMany (mappedBy = "room")
	List<RoomImage> room_images;
}
