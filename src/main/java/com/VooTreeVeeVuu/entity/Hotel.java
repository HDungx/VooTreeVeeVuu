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
	String hotel_Id;
	@NotBlank
	@Column(columnDefinition = "nvarchar(255)")
	String address;
	@NotBlank
	@Size(min = 3, max = 10)
	String hotel_phoneNum;
	@NotNull
	@Min(1) @Max(5)
	int hotel_stars;
	@NotBlank
	@Column(columnDefinition = "nvarchar(255)")
	String hotel_description;
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
	List<HotelImage> hotel_Images;
	@NotNull
	@Min(1)
	int num_of_room;
	@NotNull
	@Min(2)
	int num_of_guest;
	@JsonIgnore
	@OneToMany (mappedBy = ("hotel"))
	List<Room> rooms;
	@OneToMany (mappedBy = ("hotel"))
	List<HotelFacility> hotel_Facilities;
	@JsonIgnore
	@OneToMany (mappedBy = "hotel")
	List<Rating> listRating;
	@OneToMany(mappedBy = "hotel")
	List<Logs> logs;
	public enum Hotel_status {
		PENDING, ACTIVE, INACTIVE, REJECTED
	}
}
