package com.VooTreeVeeVuu.domain.entity;

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
	private Long id;
	//@JsonIgnored
	@NotBlank
	@ManyToOne
	@JoinColumn (name = "facId")
	Facility facility;
	//@JsonIgnored
	@NotBlank
	@ManyToOne
	@JoinColumn (name = "hotelId")
	Hotel hotel;
}
