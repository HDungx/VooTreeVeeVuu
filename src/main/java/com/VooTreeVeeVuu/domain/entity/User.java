package com.VooTreeVeeVuu.domain.entity;


import com.VooTreeVeeVuu.domain.utils.Gender;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Users")
public class User {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "firstName", columnDefinition = "nvarchar(50)")
	private String firstName;

	@Column(name = "lastName", columnDefinition = "nvarchar(200)")
	private String lastName;

	@Enumerated (EnumType.STRING)
	Gender gender;

	@Temporal (TemporalType.DATE)
	private LocalDate dob;

	@Setter
	@OneToOne @JoinColumn(name = "account_id", referencedColumnName = "id")
	private Account account;

	@JsonIgnore
	@OneToMany (mappedBy = "user")
	List<Logs> logs;

	@JsonIgnore
	@OneToMany (mappedBy = "user")
	List<Booking> bookings;

	@JsonIgnore
	@OneToMany (mappedBy = "user")
	List<Hotel> hotels;

	@JsonIgnore
	@OneToMany (mappedBy = "user")
	List<Rating> ratings;

}
