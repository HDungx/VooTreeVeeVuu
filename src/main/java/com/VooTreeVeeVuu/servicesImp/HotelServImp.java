package com.VooTreeVeeVuu.servicesImp;

import com.VooTreeVeeVuu.domain.entity.Hotel;
import com.VooTreeVeeVuu.domain.repository.HotelRepository;
import com.VooTreeVeeVuu.services.HotelServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelServImp implements HotelServ {
	@Autowired
	HotelRepository hotelRepository;

	@Override
	public Page<Hotel> getAll (Pageable pageable) {
		return hotelRepository.findAll(pageable);
	}

	@Override
	public List<Hotel> getAll () {
		return hotelRepository.findAll();
	}

	@Override
	public Optional<Hotel> getById (String id) {
		return hotelRepository.findById(id);
	}

	@Override
	public Hotel save (Hotel hotel) {
		return hotelRepository.save(hotel);
	}

	@Override
	public void delete (String id) {
		hotelRepository.deleteById(id);
	}
}
