package com.VooTreeVeeVuu.usecase.RatingUsecase;

import com.VooTreeVeeVuu.dto.RatingDTO;
import com.VooTreeVeeVuu.domain.entity.Rating;
import com.VooTreeVeeVuu.domain.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreateRatingUseCase {
	@Autowired
	private RatingRepository ratingRepository;

	@Transactional
	public RatingDTO createRating (RatingDTO ratingDTO){
		Rating rating = toEntity(ratingDTO);
		Rating saved = ratingRepository.save(rating);
		return toDTO(saved);
	}

	private RatingDTO toDTO(Rating rating) {
		RatingDTO dto = new RatingDTO();
		dto.setComment(rating.getComment());
		dto.setRate(rating.getRate());
		dto.setHotel(rating.getHotel());
		dto.setUser(rating.getUser());
		return dto;
	}

	private Rating toEntity(RatingDTO ratingDTO) {
		Rating rating = new Rating();
		rating.setComment(ratingDTO.getComment());
		rating.setRate(ratingDTO.getRate());
		rating.setHotel(ratingDTO.getHotel());
		rating.setUser(ratingDTO.getUser());
		return rating;
	}


}
