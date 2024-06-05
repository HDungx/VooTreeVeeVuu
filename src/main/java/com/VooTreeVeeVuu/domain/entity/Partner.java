package com.VooTreeVeeVuu.domain.entity;

import com.VooTreeVeeVuu.domain.utils.Gender;
import com.VooTreeVeeVuu.domain.utils.Partner_status;
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
@Table (name = "Partners")
public class Partner {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	@Column (columnDefinition = "nvarchar(200)", name = "firstName")
	private String firstName;
	@NotBlank
	@Column (columnDefinition = "nvarchar(200)", name = "lastName")
	private String lastName;
	@NotBlank
	@Email
	@Column (unique = true)
	private String email;
	@NotBlank
	@Size (min = 3, max = 10)
	private String phoneNum;
	@Enumerated (EnumType.STRING)
	private Gender gender;
	@NotNull
	@Min (1)
	@Max (99)
	private int age;
	@Enumerated(EnumType.STRING)
	@Column(name = "status", columnDefinition = "varchar(20)")
	private Partner_status status;
	@JsonIgnore
	@OneToOne
	@JoinColumn (name = "username")
	Account account;
	@JsonIgnore
	@OneToMany (mappedBy = "partner")
	List<Hotel> hotelList;


}
