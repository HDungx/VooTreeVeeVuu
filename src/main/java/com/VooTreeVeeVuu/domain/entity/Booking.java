package com.VooTreeVeeVuu.domain.entity;

import com.VooTreeVeeVuu.domain.utils.Booking_status;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "Bookings")
public class Booking {
//	@Id
//	//@Pattern(regexp = "^BK[1-9]{4}$\n")
//	String bookingId;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@DateTimeFormat (iso = DateTimeFormat.ISO.DATE)
	@Temporal (TemporalType.DATE)
	@Column (name = "checkInDate")
	private LocalDate checkInDate;
	@NotNull
	@DateTimeFormat (iso = DateTimeFormat.ISO.DATE)
	@Temporal (TemporalType.DATE)
	@Column (name = "checkOutDate")
	private LocalDate checkOutDate;
	@NotNull
	@NumberFormat (style = NumberFormat.Style.CURRENCY)
	double totalPrice;
	@NotBlank
	@ManyToOne
	@JoinColumn (name = "customer_Id")
	Customer customer;
	@NotBlank
	@ManyToOne
	@JoinColumn (name = "roomId")
	Room room;
	@NotBlank
	@Column (columnDefinition = "nvarchar(50)")
	@Enumerated (EnumType.STRING)
	private Booking_status status;
	@DateTimeFormat (iso = DateTimeFormat.ISO.DATE)
	@Temporal (TemporalType.DATE)
	private LocalDate bookingDate;
	@NotNull
	@Min(1)
	private Integer numOfRoom;
	@NotNull
	@Min(2)
	private Integer numOfGuest;

}
