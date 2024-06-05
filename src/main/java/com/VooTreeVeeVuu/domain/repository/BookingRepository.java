package com.VooTreeVeeVuu.domain.repository;

import com.VooTreeVeeVuu.domain.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;
import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking,Long> {

//    List<Booking> findAll ();
//
//    Optional<Booking> findById (Long id);
//
//    Booking save (Booking booking) ;
//
//    void deleteById (Long id);
}