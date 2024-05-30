package com.VooTreeVeeVuu.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

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
	@Min (1)
	@Max (10)
	int rate;
	@NotBlank
	@Column (columnDefinition = "nvarchar(255)")
	String comment;
	@ManyToOne
	@JoinColumn (name = "customerId")
	Customer customer;
	@ManyToOne
	@JoinColumn (name = "hotelId")
	Hotel hotel;

}
