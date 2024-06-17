package com.VooTreeVeeVuu.usecase.RoomImageUsecase;

import com.VooTreeVeeVuu.dto.RoomImageDTO;
import com.VooTreeVeeVuu.domain.entity.RoomImage;
import com.VooTreeVeeVuu.domain.repository.RoomImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetAllRoomImageUseCase {
	@Autowired
	private RoomImageRepository roomImageRepository;

	public List<RoomImageDTO> getAllRoomImage () {
		return roomImageRepository.findAll().stream().map(this :: toDTO).collect(Collectors.toList());
	}

	private RoomImageDTO toDTO (RoomImage roomImage) {
		RoomImageDTO dto = new RoomImageDTO();
		dto.setId(roomImage.getId());
		dto.setPath(roomImage.getPath());
		dto.setRoom(roomImage.getRoom());
		return dto;
	}
}
