package com.VooTreeVeeVuu.adapters.controller;

import com.VooTreeVeeVuu.adapters.dto.RoomFacilityDTO;
import com.VooTreeVeeVuu.domain.entity.RoomFacility;
import com.VooTreeVeeVuu.usecase.RoomFacilityUsecase.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/roomFacilities")
public class RoomFacilityController {
	@Autowired
	private CreateRoomFacilityUseCase createRoomFacilityUseCase;

	@Autowired
	private UpdateRoomFacilityUseCase updateRoomFacilityUseCase;

	@Autowired
	private DeleteRoomFacilityUseCase deleteRoomFacilityUseCase;

	@Autowired
	private GetAllRoomFacilityUseCase getAllRoomFacilityUseCase;

	@Autowired
	private GetRoomFacilityUseCase getRoomFacilityUseCase;

	@GetMapping ()
	public List<RoomFacilityDTO> getAllRoomFacility(){
		return getAllRoomFacilityUseCase.getAllRoomFacility();
	}

	@GetMapping ("/{id}")
	public Optional<RoomFacilityDTO> getRoomFacilityById (@PathVariable Long id){
		return getRoomFacilityUseCase.getRoomFacilityById(id);
	}

	@PostMapping
	public RoomFacilityDTO createRoomFacility(@RequestBody RoomFacilityDTO dto) {
		return createRoomFacilityUseCase.createRoomFacility(dto);
	}

	@PutMapping ("/update/{id}")
	public Optional<RoomFacilityDTO> updateRoomFacility (@RequestBody RoomFacilityDTO dto, @PathVariable Long id) {
		return updateRoomFacilityUseCase.updateRoomFacility(id,dto);
	}

	@DeleteMapping ("/delete/{id}")
	public void deleteRoomFacility(@PathVariable Long id) {
		deleteRoomFacilityUseCase.deleteRoomFacility(id);
	}

}
