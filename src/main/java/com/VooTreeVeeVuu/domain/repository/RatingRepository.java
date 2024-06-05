package com.VooTreeVeeVuu.domain.repository;

import com.VooTreeVeeVuu.domain.entity.Rating;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface RatingRepository extends JpaRepository<Rating, Integer> {
	@Query("SELECT o FROM Rating o WHERE o.customer.customerId LIKE ?1 OR o.hotel.hotelId LIKE ?1")
	Optional<Page<Rating>> getByCusIdOrHotelId(String keyword, Pageable pageable);
}