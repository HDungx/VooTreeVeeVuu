package com.VooTreeVeeVuu.domain.repository;

import com.VooTreeVeeVuu.domain.entity.Facility;

import java.util.List;
import java.util.Optional;

public interface FacilityRepository  {
    List<Facility> findAll ();

    Optional<Facility> findById (Integer id);

    Facility save (Facility facility);

    void deleteById (Integer id);
}