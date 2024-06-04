package com.VooTreeVeeVuu.domain.entity;

import com.VooTreeVeeVuu.utils.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "Accounts")

public class Account {
	@Id
	String username;
	@Email
	@Column (unique = true, nullable = false, name = "email")
	String email;
	@NotBlank
	@Size (min = 6, max = 20, message = "Password must be between 6 and 20 characters long")
	@Column(name = "password")
	String password;
	@Column (columnDefinition = "nvarchar(50)", name = "role")
	@Enumerated(EnumType.STRING)
	Role role;
	@JsonIgnore
	@OneToOne (mappedBy = ("account"))
	Customer customer;
	@JsonIgnore
	@OneToOne (mappedBy = ("account"))
	Partner partner;
	@JsonIgnore
	@OneToOne (mappedBy = ("account"))
	Staff staff;
}
