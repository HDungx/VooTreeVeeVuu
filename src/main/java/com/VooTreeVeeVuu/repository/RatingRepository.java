package com.VooTreeVeeVuu.repository;

import com.VooTreeVeeVuu.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<Rating, Integer> {
}