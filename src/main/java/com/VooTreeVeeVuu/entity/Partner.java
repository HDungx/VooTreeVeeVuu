package com.VooTreeVeeVuu.entity;

import com.VooTreeVeeVuu.utils.Gender;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "Partners")
public class Partner {
	@Id
	String partner_Id;
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
	@NotBlank
	@Size (min = 3, max = 10)
	String phoneNum;
	@Enumerated(EnumType.STRING)
	Gender gender;
	@NotNull
	@Min (1)
	@Max (80)
	int age;
	@JsonIgnore
	@OneToOne
	@JoinColumn (name = "username")
	Account account;
	@JsonIgnore
	@OneToMany (mappedBy = "partner")
	List<Hotel> hotelList;

}
