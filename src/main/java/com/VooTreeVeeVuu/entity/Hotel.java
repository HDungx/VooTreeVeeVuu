package com.VooTreeVeeVuu.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "Hotels")
public class Hotel {
	@Id
	String hotelId;
	@NotBlank
	@Column(columnDefinition = "nvarchar(255)")
	String address;
	@NotBlank
	@Column(columnDefinition = "nvarchar(50)")
	String city;
	@NotBlank
	@Size(min = 3, max = 10)
	String hotelPhoneNum;
	@NotNull
	@Min(1) @Max(5)
	int hotelStars;
	@NotBlank
	@Column(columnDefinition = "nvarchar(255)")
	String hotelDescription;
	@Enumerated(EnumType.STRING)
	Hotel_status status;
	@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	@Temporal (TemporalType.TIME)
	LocalTime checkInTime;
	@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	@Temporal (TemporalType.TIME)
	LocalTime checkOutTime;
	@ManyToOne
	@JoinColumn (name = "staff_Id")
	Staff staff;
	@ManyToOne
	@JoinColumn (name = "type_Id")
	AccommodationType accommodationType;
	@ManyToOne
	@JoinColumn (name = "partner_Id")
	Partner partner;
	@OneToMany (mappedBy = ("hotel"))
	List<HotelImage> hotelImages;
	@NotNull
	@Min(1)
	int numOfRoom;
	@NotNull
	@Min(2)
	int numOfGuest;
	@JsonIgnore
	@OneToMany (mappedBy = ("hotel"))
	List<Room> rooms;
	@OneToMany (mappedBy = ("hotel"))
	List<HotelFacility> hotelFacilities;
	@JsonIgnore
	@OneToMany (mappedBy = "hotel")
	List<Rating> listRating;
	@OneToMany(mappedBy = "hotel")
	List<Logs> logs;
	public enum Hotel_status {
		PENDING, ACTIVE, INACTIVE, REJECTED
	}
}
