package com.VooTreeVeeVuu.adapters.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PassChangeDTO {
	private String oldPassword;
	private String newPassword;
	private String confPassword;
}
