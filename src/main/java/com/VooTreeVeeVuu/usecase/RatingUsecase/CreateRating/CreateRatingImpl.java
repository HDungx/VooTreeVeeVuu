package com.VooTreeVeeVuu.usecase.RatingUsecase.CreateRating;

import com.VooTreeVeeVuu.domain.entity.Hotel;
import com.VooTreeVeeVuu.domain.entity.User;
import com.VooTreeVeeVuu.domain.repository.HotelRepository;
import com.VooTreeVeeVuu.domain.repository.UserRepository;
import com.VooTreeVeeVuu.dto.CreateRatingDTO;
import com.VooTreeVeeVuu.dto.RatingDTO;
import com.VooTreeVeeVuu.domain.entity.Rating;
import com.VooTreeVeeVuu.domain.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
public class CreateRatingImpl implements CreateRating {
	private final HotelRepository hotelRepository;
	private final UserRepository userRepository;
	private final RatingRepository ratingRepository;

	public CreateRatingImpl (HotelRepository hotelRepository, UserRepository userRepository,
	                         RatingRepository ratingRepository) {this.hotelRepository = hotelRepository;
		this.userRepository = userRepository;
		this.ratingRepository = ratingRepository;
	}

	@Override
	public RatingDTO createRating (CreateRatingDTO createRatingDTO) {
		Rating rating = new Rating();
		rating.setRate(createRatingDTO.getRate());
		rating.setComment(createRatingDTO.getComment());
		rating.setDate(LocalDate.now());

		Hotel hotel = hotelRepository.findById(createRatingDTO.getHotelId())
				.orElseThrow(() -> new RuntimeException("Hotel not found"));
		User user = userRepository.findById(createRatingDTO.getUserId())
				.orElseThrow(() -> new RuntimeException("User not found"));

		rating.setHotel(hotel);
		rating.setUser(user);

		Rating savedRating = ratingRepository.save(rating);
		return convertToDTO(savedRating);
	}

	private RatingDTO convertToDTO(Rating rating) {
		RatingDTO dto = new RatingDTO();
		dto.setId(rating.getId());
		dto.setRate(rating.getRate());
		dto.setComment(rating.getComment());
		dto.setDate(rating.getDate());
		dto.setHotel(rating.getHotel());
		dto.setUser(rating.getUser());
		return dto;
	}
}
