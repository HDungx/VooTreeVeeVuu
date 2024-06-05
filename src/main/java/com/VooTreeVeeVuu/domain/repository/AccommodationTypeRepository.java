package com.VooTreeVeeVuu.domain.repository;

import com.VooTreeVeeVuu.domain.entity.AccommodationType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AccommodationTypeRepository  {
    List<AccommodationType> findAll ();

    Optional<AccommodationType> findById (String id);

    AccommodationType save (AccommodationType accommodationType);

    void deleteById (String id);

}