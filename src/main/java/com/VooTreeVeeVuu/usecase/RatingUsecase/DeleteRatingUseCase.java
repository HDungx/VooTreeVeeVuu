package com.VooTreeVeeVuu.usecase.RatingUsecase;

import com.VooTreeVeeVuu.domain.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeleteRatingUseCase {
	@Autowired
	private RatingRepository ratingRepository;

	@Transactional
	public void deleteRating(Long id){ratingRepository.deleteById(id);
	}
}
