package com.VooTreeVeeVuu.usecase.RoomFacilityUsecase;

import com.VooTreeVeeVuu.adapters.dto.GetAllRoomFacDTO;
import com.VooTreeVeeVuu.adapters.dto.RoomFacilityDTO;
import com.VooTreeVeeVuu.domain.entity.RoomFacility;
import com.VooTreeVeeVuu.domain.repository.RoomFacilityRepository;
import com.VooTreeVeeVuu.domain.repository.RoomTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UpdateRoomFacilityUseCase {
//	@Autowired
//	private RoomFacilityRepository roomFacilityRepository;
//
//	@Transactional
//	public Optional<GetAllRoomFacDTO> updateRoomFacility(Long id, RoomFacilityDTO roomFacilityDTO){
//		return roomFacilityRepository.findById(id).map(roomFacility -> {
//			roomFacility.setFacility(roomFacilityDTO.getFacilityId());
//			roomFacility.setRoom(roomFacilityDTO.getRoom());
//			RoomFacility updated = roomFacilityRepository.save(roomFacility);
//			return toDTO(updated);
//		});
//	}
//
//	private RoomFacilityDTO toDTO(RoomFacility roomFacility) {
//		RoomFacilityDTO dto = new RoomFacilityDTO();
//		dto.setFacility(roomFacility.getFacility());
//		dto.setRoom(roomFacility.getRoom());
//		return dto;
//	}
}
