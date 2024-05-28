package com.VooTreeVeeVuu.services;

import com.VooTreeVeeVuu.entity.Hotel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface HotelServ {
	public Page<Hotel> getAll (Pageable pageable);

	public Optional<Hotel> getById (String id);

	public Hotel save (Hotel hotel);

	public void delete (String id);
}
