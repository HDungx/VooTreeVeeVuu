package com.VooTreeVeeVuu.servicesImp;

import com.VooTreeVeeVuu.entity.Booking;
import com.VooTreeVeeVuu.repository.BookingRepository;
import com.VooTreeVeeVuu.services.BookingServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingServImp implements BookingServ {
	@Autowired
	BookingRepository bookingRepository;

	@Override
	public List<Booking> getAll () {
		return bookingRepository.findAll();
	}

	@Override
	public Optional<Booking> getById (String id) {
		return bookingRepository.findById(id);
	}

	@Override
	public Booking save (Booking booking) {
		return bookingRepository.save(booking);
	}

	@Override
	public void delete (String id) {
		bookingRepository.deleteById(id);
	}
}
