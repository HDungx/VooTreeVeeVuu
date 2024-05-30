package com.VooTreeVeeVuu.servicesImp;

import com.VooTreeVeeVuu.entity.Rating;
import com.VooTreeVeeVuu.repository.RatingRepository;
import com.VooTreeVeeVuu.services.RatingServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RatingServImp implements RatingServ {
	@Autowired
	RatingRepository ratingRepository;

	@Override
	public Page<Rating> getAll (Pageable pageable) {
		return ratingRepository.findAll(pageable);
	}

	@Override
	public List<Rating> getAll () {
		return ratingRepository.findAll();
	}

	@Override
	public Optional<Rating> getById (Integer id) {
		return ratingRepository.findById(id);
	}

	@Override
	public Optional<Page<Rating>> getByCusIDorHotelID (String keyword, Pageable pageable) {
		return ratingRepository.getByCusIdOrHotelId(keyword, pageable);
	}

	@Override
	public Rating save (Rating rating) {
		return ratingRepository.save(rating);
	}

	@Override
	public void delete (Integer id) {
		ratingRepository.deleteById(id);
	}
}
