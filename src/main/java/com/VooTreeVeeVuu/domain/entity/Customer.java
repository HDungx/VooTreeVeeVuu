package com.VooTreeVeeVuu.domain.entity;


import com.VooTreeVeeVuu.utils.Gender;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "Customers")
public class Customer {
	@Id
	@Pattern (regexp = "^CUS[1-9]{3}$\n")
	String customerId;
	@NotBlank
	@Column (columnDefinition = "nvarchar(200)", name = "firstName")
	String firstName;
	@NotBlank
	@Column (columnDefinition = "nvarchar(200)", name = "lastName")
	String lastName;
	@NotBlank
	@Email
	@Column (unique = true, name = "email")
	String email;
	@NotBlank
	@Size (min = 3, max = 10)
	@Column (name = "phoneNum")
	String phoneNum;
	@Column (name = "gender")
	@Enumerated (EnumType.STRING)
	Gender gender;
	@NotNull
	@Min (1)
	@Max (99)
	int age;
	boolean status;
	@OneToOne
	@JoinColumn (name = "username")
	Account account;
	@JsonIgnore
	@OneToMany (mappedBy = "customer")
	List<Rating> listRating;
	@JsonIgnore
	@OneToMany (mappedBy = "customer")
	List<Booking> listBooking;
}
