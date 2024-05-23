package com.VooTreeVeeVuu.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Hotels")
public class Hotel {
	@Id
	String hotel_Id;
	String address;
	String hotel_phoneNum;
	int hotel_stars;
	String hotel_description;
	String status;
	@Temporal(TemporalType.TIME)
	LocalTime checkInTime;
	@Temporal(TemporalType.TIME)
	LocalTime checkOutTime;
	@ManyToOne @JoinColumn(name="staff_Id")
	Staff staff;
	@ManyToOne @JoinColumn(name="type_Id")
	AccommodationType accommodationType;
	@ManyToOne @JoinColumn(name="partner_Id")
	Partner partner;
	@OneToMany (mappedBy = ("hotel"))
	List<HotelImage> hotel_Images;
	@JsonIgnore
	@OneToMany (mappedBy = ("hotel"))
	List<Room> rooms;
	@OneToMany (mappedBy = ("hotel"))
	List<HotelFacility> hotel_Facilities;
	@JsonIgnore
	@OneToMany (mappedBy = "hotel")
	List<Rating> listRating;
}
