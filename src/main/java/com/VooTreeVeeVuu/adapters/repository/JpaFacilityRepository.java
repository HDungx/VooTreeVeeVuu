package com.VooTreeVeeVuu.adapters.repository;

import com.VooTreeVeeVuu.domain.entity.Facility;
import com.VooTreeVeeVuu.domain.repository.FacilityRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaFacilityRepository extends JpaRepository<Facility, Integer>, FacilityRepository {
}
