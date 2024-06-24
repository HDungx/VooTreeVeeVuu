package com.VooTreeVeeVuu.usecase.HotelImageUsecase.DeleteHotelImage;

import com.VooTreeVeeVuu.domain.repository.HotelImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeleteHotelImageImpl implements DeleteHotelImage {
	@Autowired
	private HotelImageRepository hotelImageRepository;

	@Transactional
	public void deleteHotelImage (Long id) {
		hotelImageRepository.deleteById(id);
	}
}
