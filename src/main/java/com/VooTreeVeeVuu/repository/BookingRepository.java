package com.VooTreeVeeVuu.repository;

import com.VooTreeVeeVuu.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, String> {
}