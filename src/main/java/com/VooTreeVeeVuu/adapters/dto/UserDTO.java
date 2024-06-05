package com.VooTreeVeeVuu.adapters.dto;


import com.VooTreeVeeVuu.domain.utils.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
	private Long id;
	private String firstName;
	private String lastName;
	private String dob;
	private Gender gender;
}
