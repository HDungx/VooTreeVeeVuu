package com.VooTreeVeeVuu.domain.entity;

import java.time.LocalTime;
import java.util.List;

import com.VooTreeVeeVuu.domain.utils.Hotel_status;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "Hotels")
public class Hotel {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Column(columnDefinition = "nvarchar(255)", name = "address")
	private String address;

	@NotBlank
	@Column(columnDefinition = "nvarchar(255)", name = "hotelName")
	private String hotelName;

	@NotBlank
	@Column(columnDefinition = "nvarchar(50)", name = "city")
	private String city;

	@NotBlank
	@Size(min = 3, max = 10)
	@Column(name = "hotelPhoneNum")
	private String hotelPhoneNum;

	@NotNull
	@Min(1) @Max(5)
	private int hotelStars;

	@NotBlank
	@Column(columnDefinition = "nvarchar(255)", name = "description")
	private String hotelDescription;

	@Enumerated(EnumType.STRING)
	private Hotel_status status;

	@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	@Temporal (TemporalType.TIME)
	@Column(name = "checkInTime")
	private LocalTime checkInTime;

	@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	@Temporal (TemporalType.TIME)
	@Column(name = "checkOutTime")
	private LocalTime checkOutTime;

	//@JsonIgnored
	@ManyToOne
	@JoinColumn (name = "typeId")
	AccommodationType accommodationType;

	@JsonIgnore
	@ManyToOne
	@JoinColumn (name = "userId")
	User user;

	//@JsonIgnored
	@OneToMany (mappedBy = "hotel", cascade = CascadeType.ALL, orphanRemoval = true)
	List<HotelImage> hotelImages;

	//@JsonIgnore
	@OneToMany (mappedBy = ("hotel"))
	List<Room> rooms;

	//@JsonIgnore
	@OneToMany (mappedBy = ("hotel"))
	List<HotelFacility> hotelFacilities;

	//@JsonIgnore
	@OneToMany (mappedBy = "hotel")
	List<Rating> listRating;

	@JsonIgnore
	@OneToMany(mappedBy = "hotel")
	List<Logs> logs;
}
