package com.VooTreeVeeVuu.usecase.RoomFacilityUsecase;


import com.VooTreeVeeVuu.adapters.dto.RoomFacilityDTO;
import com.VooTreeVeeVuu.domain.entity.RoomFacility;
import com.VooTreeVeeVuu.domain.repository.RoomFacilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreateRoomFacilityUseCase {
	@Autowired
	private RoomFacilityRepository roomFacilityRepository;

	@Transactional
	public RoomFacilityDTO createRoomFacility (RoomFacilityDTO roomFacilityDTO){
		RoomFacility roomFacility = toEntity(roomFacilityDTO);
		RoomFacility saved = roomFacilityRepository.save(roomFacility);
		return toDTO(saved);
	}

	private RoomFacilityDTO toDTO(RoomFacility roomFacility) {
		RoomFacilityDTO dto = new RoomFacilityDTO();
		dto.setFacility(roomFacility.getFacility());
		dto.setRoom(roomFacility.getRoom());
		return dto;
	}

	private RoomFacility toEntity(RoomFacilityDTO roomFacilityDTO) {
		RoomFacility roomFacility = new RoomFacility();
		roomFacility.setFacility(roomFacilityDTO.getFacility());
		roomFacility.setRoom(roomFacilityDTO.getRoom());
		return roomFacility;
	}
}
