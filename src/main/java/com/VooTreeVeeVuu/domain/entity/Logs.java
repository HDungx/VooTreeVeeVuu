package com.VooTreeVeeVuu.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "logs")
public class Logs {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	Integer id;
	@Column (name = "action", columnDefinition = "nvarchar(50)")
	@Enumerated (EnumType.STRING)
	Action action;
	@DateTimeFormat (iso = DateTimeFormat.ISO.DATE)
	@Temporal (TemporalType.DATE)
	@Column (name = "actionDate")
	LocalDate date;
	@ManyToOne
	@JoinColumn (name = "hotelId")
	Hotel hotel;
	@ManyToOne
	@JoinColumn (name = "staffId")
	Staff staff;

	public enum Action {
		CREATE, UPDATE
	}
}
