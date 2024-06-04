package com.VooTreeVeeVuu.adapters.repository;

import com.VooTreeVeeVuu.domain.entity.Booking;
import com.VooTreeVeeVuu.domain.repository.BookingRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaBookingRepository extends JpaRepository<Booking,String>,BookingRepository{
}
