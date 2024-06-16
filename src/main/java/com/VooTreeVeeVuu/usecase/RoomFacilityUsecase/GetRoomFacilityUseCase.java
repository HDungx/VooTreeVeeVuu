package com.VooTreeVeeVuu.usecase.RoomFacilityUsecase;



import com.VooTreeVeeVuu.adapters.dto.RoomFacilityDTO;
import com.VooTreeVeeVuu.domain.entity.RoomFacility;
import com.VooTreeVeeVuu.domain.repository.RoomFacilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class GetRoomFacilityUseCase {
//	@Autowired
//	private RoomFacilityRepository roomFacilityRepository;
//
//	public Optional<RoomFacilityDTO> getRoomFacilityById(Long id){
//		return roomFacilityRepository.findById(id).map(this :: toDTO);
//	}
//
//	private RoomFacilityDTO toDTO(RoomFacility roomFacility) {
//		RoomFacilityDTO dto = new RoomFacilityDTO();
//		dto.setId(roomFacility.getId());
//		dto.setFacility(roomFacility.getFacility());
//		dto.setRoom(roomFacility.getRoom());
//		return dto;
//	}
}
