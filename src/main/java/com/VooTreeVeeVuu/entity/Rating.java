package com.VooTreeVeeVuu.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "rating")
public class Rating {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	Integer id;
	@NotNull
	@Min(1) @Max(5)
	int rate;
	@NotBlank
	@Column(columnDefinition = "nvarchar(255)")
	String comment;
	@ManyToOne
	@JoinColumn (name = "customer_Id")
	Customer customer;
	@ManyToOne
	@JoinColumn (name = "hotel_Id")
	Hotel hotel;

}
