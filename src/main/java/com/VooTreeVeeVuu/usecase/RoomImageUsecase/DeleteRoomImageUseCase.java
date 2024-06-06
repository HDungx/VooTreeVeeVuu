package com.VooTreeVeeVuu.usecase.RoomImageUsecase;

import com.VooTreeVeeVuu.domain.repository.HotelImageRepository;
import com.VooTreeVeeVuu.domain.repository.RoomImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeleteRoomImageUseCase {
	@Autowired
	private RoomImageRepository roomImageRepository;

	@Transactional
	public void deleteRoomImage (Long id) {
		roomImageRepository.deleteById(id);
	}
}
