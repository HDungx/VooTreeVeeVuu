package com.VooTreeVeeVuu.usecase.RatingUsecase.UpdateRating;

import com.VooTreeVeeVuu.dto.RatingDTO;

import java.util.Optional;

public interface UpdateRating {
	Optional<RatingDTO> updateRatings(Long id, RatingDTO ratingDTO);
}
