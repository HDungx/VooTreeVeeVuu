package com.VooTreeVeeVuu.domain.repository;

import com.VooTreeVeeVuu.domain.entity.Booking;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
import java.util.Optional;

public interface BookingRepository {

    List<Booking> findAll ();

    Optional<Booking> findById (String id);

    Booking save (Booking booking) ;

    void deleteById (String id);
}