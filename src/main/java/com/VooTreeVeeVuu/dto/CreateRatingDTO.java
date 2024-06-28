package com.VooTreeVeeVuu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateRatingDTO {
	private int rate;
	private String comment;
	private Long userId;
	private Long hotelId;
}
