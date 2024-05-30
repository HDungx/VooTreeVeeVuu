package com.VooTreeVeeVuu.services;

import com.VooTreeVeeVuu.entity.Rating;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface RatingServ {
	public Page<Rating> getAll (Pageable pageable);

	public List<Rating> getAll ();

	public Optional<Rating> getById (Integer id);

	public Optional<Page<Rating>> getByCusIDorHotelID (String keyword, Pageable pageable);

	public Rating save (Rating rating);

	public void delete (Integer id);
}
