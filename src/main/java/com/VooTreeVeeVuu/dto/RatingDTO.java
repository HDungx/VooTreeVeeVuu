package com.VooTreeVeeVuu.dto;


import com.VooTreeVeeVuu.domain.entity.Hotel;
import com.VooTreeVeeVuu.domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RatingDTO {
	private Long id;
	private int rate;
	private String comment;
	private LocalDate date;
	private User user;
	private Hotel hotel;
}
