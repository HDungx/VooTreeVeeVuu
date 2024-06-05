package com.VooTreeVeeVuu.adapters.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignUpDTO {
	private String username;
	private String password;
	private String email;
	private LocalDate dob;
	private Set<String> roles;
}
