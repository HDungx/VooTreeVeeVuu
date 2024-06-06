package com.VooTreeVeeVuu.usecase.RoomTypeUsecase;

import com.VooTreeVeeVuu.domain.repository.RoomTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeleteRoomTypeUseCase {
	@Autowired
	private RoomTypeRepository roomTypeRepository;

	@Transactional
	public void deleteRoomType(Long id){roomTypeRepository.deleteById(id);
	}
}
