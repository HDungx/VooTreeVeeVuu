package com.VooTreeVeeVuu.usecase.RatingUsecase.UpdateRating;

import com.VooTreeVeeVuu.dto.RatingDTO;
import com.VooTreeVeeVuu.domain.entity.Rating;
import com.VooTreeVeeVuu.domain.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UpdateRatingImpl implements UpdateRating {
	@Autowired
	private RatingRepository ratingRepository;

	@Transactional
	public Optional<RatingDTO> updateRatings(Long id, RatingDTO ratingDTO){
		return ratingRepository.findById(id).map(rating -> {
			rating.setComment(ratingDTO.getComment());
			rating.setRate(ratingDTO.getRate());
			rating.setHotel(ratingDTO.getHotel());
			rating.setUser(ratingDTO.getUser());
			Rating updated = ratingRepository.save(rating);
			return toDTO(updated);
		});
	}

	private RatingDTO toDTO(Rating rating) {
		RatingDTO dto = new RatingDTO();
		dto.setComment(rating.getComment());
		dto.setRate(rating.getRate());
		dto.setHotel(rating.getHotel());
		dto.setUser(rating.getUser());
		return dto;
	}

}
