package com.VooTreeVeeVuu.domain.repository;

import com.VooTreeVeeVuu.domain.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface HotelRepository extends JpaRepository<Hotel, Long>{
//    List<Hotel> findAll ();
//
//    Optional<Hotel> findById (Long id);
//
//    Hotel save (Hotel hotel) ;
//
//    void deleteById (Long id);
}