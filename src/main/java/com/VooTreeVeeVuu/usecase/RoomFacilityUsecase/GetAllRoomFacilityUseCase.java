package com.VooTreeVeeVuu.usecase.RoomFacilityUsecase;


import com.VooTreeVeeVuu.adapters.dto.RoomFacilityDTO;
import com.VooTreeVeeVuu.domain.entity.RoomFacility;
import com.VooTreeVeeVuu.domain.repository.RoomFacilityRepository;
import com.VooTreeVeeVuu.domain.repository.RoomTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetAllRoomFacilityUseCase {
//	@Autowired
//	private RoomFacilityRepository roomFacilityRepository;
//
//	public List<RoomFacilityDTO> getAllRoomFacility(){
//		return roomFacilityRepository.findAll().stream().map(this :: toDTO).collect(Collectors.toList());
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
