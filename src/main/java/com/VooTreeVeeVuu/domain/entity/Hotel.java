package com.VooTreeVeeVuu.domain.entity;

import java.time.LocalTime;
import java.util.List;

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
	@Pattern(regexp = "^H[1-9]{3}$\n")
	String hotelId;
	@NotBlank
	@Column(columnDefinition = "nvarchar(255)", name = "address")
	String address;
	@NotBlank
	@Column(columnDefinition = "nvarchar(50)", name = "city")
	String city;
	@NotBlank
	@Size(min = 3, max = 10)
	@Column(name = "hotelPhoneNum")
	String hotelPhoneNum;
	@NotNull
	@Min(1) @Max(5)
	int hotelStars;
	@NotBlank
	@Column(columnDefinition = "nvarchar(255)", name = "description")
	String hotelDescription;
	@Enumerated(EnumType.STRING)
	Hotel_status status;
	@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	@Temporal (TemporalType.TIME)
	@Column(name = "checkInTime")
	LocalTime checkInTime;
	@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	@Temporal (TemporalType.TIME)
	@Column(name = "checkOutTime")
	LocalTime checkOutTime;
	@ManyToOne
	@JoinColumn (name = "typeId")
	AccommodationType accommodationType;
	@ManyToOne
	@JoinColumn (name = "partnerId")
	Partner partner;
	@OneToMany (mappedBy = ("hotel"))
	List<HotelImage> hotelImages;
	@NotNull
	@Min(1)
	Integer numOfRoom;
	@NotNull
	@Min(2)
	Integer numOfGuest;
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
