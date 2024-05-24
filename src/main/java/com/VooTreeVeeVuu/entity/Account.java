package com.VooTreeVeeVuu.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "Accounts")

public class Account {
	@Id
	@Column(unique = true)
	String username;
	@Email
	@Column (unique = true, nullable = false)
	String email;
	@NotBlank
	@Size (min = 6, max = 20, message = "Password must be between 6 and 20 characters long")
	String password;
	@Column (columnDefinition = "nvarchar(50)")
	String role;
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
