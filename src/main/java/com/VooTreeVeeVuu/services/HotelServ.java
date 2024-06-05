package com.VooTreeVeeVuu.services;

import com.VooTreeVeeVuu.domain.entity.Hotel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface HotelServ {
	public Page<Hotel> getAll (Pageable pageable);

	public List<Hotel> getAll();

	public Optional<Hotel> getById (String id);

	public Hotel save (Hotel hotel);

	public void delete (String id);
}
