package com.VooTreeVeeVuu.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "logs")
public class Logs {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	Integer id;
	@Column (name = "action", columnDefinition = "nvarchar(255)")
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
