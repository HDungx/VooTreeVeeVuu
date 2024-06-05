package com.VooTreeVeeVuu.domain.entity;


import com.VooTreeVeeVuu.domain.utils.Gender;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "staffs")
public class Staff {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	@Column (columnDefinition = "nvarchar(200)")
	private String firstName;
	@NotBlank
	@Column (columnDefinition = "nvarchar(200)")
	private String lastName;
	@NotBlank
	@Email
	@Column (unique = true)
	private String email;
	@Enumerated(EnumType.STRING)
	private Gender gender;
	@NotBlank
	@Size (min = 3, max = 10)
	private String phoneNum;
	@JsonIgnore
	@OneToOne
	@JoinColumn (name = "username")
	Account account;
	@JsonIgnore
	@OneToMany (mappedBy = "staff")
	List<Logs> logsList;
}
