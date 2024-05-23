package com.VooTreeVeeVuu.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
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
}
