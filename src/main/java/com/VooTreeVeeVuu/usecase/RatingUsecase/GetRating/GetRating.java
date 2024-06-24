package com.VooTreeVeeVuu.usecase.RatingUsecase.GetRating;

import com.VooTreeVeeVuu.dto.RatingDTO;

import java.util.Optional;

public interface GetRating {
	Optional<RatingDTO> getRatingById(Long id);
}
