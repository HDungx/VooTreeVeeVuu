package com.VooTreeVeeVuu.entity;


import com.VooTreeVeeVuu.utils.Gender;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "staffs")
public class Staff {
	@Id
	String staff_Id;
	@NotBlank
	@Column (columnDefinition = "nvarchar(200)")
	String firstName;
	@NotBlank
	@Column (columnDefinition = "nvarchar(200)")
	String lastName;
	@NotBlank
	@Email
	@Column (unique = true)
	String email;
	@Enumerated(EnumType.STRING)
	Gender gender;
	@NotBlank
	@Size (min = 3, max = 10)
	String phoneNum;
	@JsonIgnore
	@OneToMany (mappedBy = "staff")
	List<Hotel> hotels;
	@JsonIgnore
	@OneToOne
	@JoinColumn (name = "username")
	Account account;
	@OneToMany (mappedBy = "staff")
	List<Logs> logsList;
}
