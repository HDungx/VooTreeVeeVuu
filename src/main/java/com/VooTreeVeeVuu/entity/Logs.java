package com.VooTreeVeeVuu.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
	String action;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@Temporal(TemporalType.DATE)
	LocalDate date;
	@ManyToOne
	@JoinColumn (name = "hotel_Id")
	Hotel hotel;
	@ManyToOne @JoinColumn(name = "staff_Id")
	Staff staff;
}
