package com.VooTreeVeeVuu.usecase.RatingUsecase.DeleteRating;

import com.VooTreeVeeVuu.domain.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeleteRatingImpl implements DeleteRating {
	@Autowired
	private RatingRepository ratingRepository;

	@Transactional
	public void deleteRating(Long id){ratingRepository.deleteById(id);
	}
}
