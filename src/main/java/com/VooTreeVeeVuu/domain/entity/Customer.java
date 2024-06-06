//package com.VooTreeVeeVuu.domain.entity;
//
//
//import com.VooTreeVeeVuu.domain.utils.Gender;
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import jakarta.persistence.*;
//import jakarta.validation.constraints.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.util.List;
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity
//@Table (name = "Customers")
//public class Customer {
//	@Id
//	@GeneratedValue (strategy = GenerationType.IDENTITY)
//	private Long id;
//	@NotBlank
//	@Column (columnDefinition = "nvarchar(200)", name = "firstName")
//	private String firstName;
//	@NotBlank
//	@Column (columnDefinition = "nvarchar(200)", name = "lastName")
//	private String lastName;
//	@NotBlank
//	@Email
//	@Column (unique = true, name = "email")
//	private String email;
//	@NotBlank
//	@Size (min = 3, max = 10)
//	@Column (name = "phoneNum")
//	private String phoneNum;
//	@Column (name = "gender")
//	@Enumerated (EnumType.STRING)
//	private Gender gender;
//	@NotNull
//	@Min (1)
//	@Max (99)
//	private int age;
//	private boolean status;
//	@OneToOne
//	@JoinColumn (name = "username")
//	Account account;
//	@JsonIgnore
//	@OneToMany (mappedBy = "customer")
//	List<Rating> listRating;
//	@JsonIgnore
//	@OneToMany (mappedBy = "customer")
//	List<Booking> listBooking;
//}
