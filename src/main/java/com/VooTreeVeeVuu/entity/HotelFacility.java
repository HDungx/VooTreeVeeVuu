package com.VooTreeVeeVuu.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "HotelFacilities")
public class HotelFacility {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	Integer id;
	@NotBlank
	@ManyToOne
	@JoinColumn (name = "fac_Id")
	Facility facility;
	@NotBlank
	@ManyToOne
	@JoinColumn (name = "hotel_Id")
	Hotel hotel;
}
