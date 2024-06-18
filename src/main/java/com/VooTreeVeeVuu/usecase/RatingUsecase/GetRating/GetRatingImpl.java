package com.VooTreeVeeVuu.usecase.RatingUsecase.GetRating;

import com.VooTreeVeeVuu.dto.RatingDTO;
import com.VooTreeVeeVuu.domain.entity.Rating;
import com.VooTreeVeeVuu.domain.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetRatingImpl implements GetRating {
	@Autowired
	private RatingRepository ratingRepository;

	public Optional<RatingDTO> getRatingById(Long id){
		return ratingRepository.findById(id).map(this :: toDTO);
	}

	private RatingDTO toDTO(Rating rating) {
		RatingDTO dto = new RatingDTO();
		dto.setId(rating.getId());
		dto.setComment(rating.getComment());
		dto.setRate(rating.getRate());
		dto.setHotel(rating.getHotel());
		dto.setUser(rating.getUser());
		return dto;
	}


}
