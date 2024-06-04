package com.VooTreeVeeVuu.adapters.repository;

import com.VooTreeVeeVuu.domain.entity.AccommodationType;
import com.VooTreeVeeVuu.domain.repository.AccommodationTypeRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaAccommodationTypeRepository extends JpaRepository<AccommodationType,String>, AccommodationTypeRepository {
}
