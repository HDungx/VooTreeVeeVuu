package com.VooTreeVeeVuu.usecase.RoomImageUsecase.UpdateRoomImage;

import com.VooTreeVeeVuu.dto.RoomImageDTO;
import com.VooTreeVeeVuu.domain.entity.RoomImage;
import com.VooTreeVeeVuu.domain.repository.RoomImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UpdateRoomImageImpl implements UpdateRoomImage{
	@Autowired
	private RoomImageRepository roomImageRepository;

	@Transactional
	public Optional<RoomImageDTO> updateRoomImage (Long id, RoomImageDTO roomImageDTO) {
		return roomImageRepository.findById(id).map(roomImage -> {
			roomImage.setPath(roomImageDTO.getPath());
			roomImage.setRoom(roomImageDTO.getRoom());
			RoomImage updated = roomImageRepository.save(roomImage);
			return toDTO(updated);
		});
	}

	private RoomImageDTO toDTO (RoomImage roomImage) {
		RoomImageDTO dto = new RoomImageDTO();
		dto.setPath(roomImage.getPath());
		dto.setRoom(roomImage.getRoom());
		return dto;
	}
}
