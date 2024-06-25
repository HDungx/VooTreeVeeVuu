package com.VooTreeVeeVuu.services;

import com.VooTreeVeeVuu.domain.entity.*;
import com.VooTreeVeeVuu.domain.repository.*;
import com.VooTreeVeeVuu.dto.RoomDTO;
import com.VooTreeVeeVuu.dto.RoomFacilityDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class RoomService {
	@Autowired
	private RoomRepository roomRepository;

	@Autowired
	private RoomTypeRepository roomTypeRepository;

	@Autowired
	private FacilityRepository facilityRepository;

	@Autowired
	private RoomFacilityRepository roomFacilityRepository;

	@Autowired
	private HotelRepository hotelRepository;

	@Transactional
	public List<RoomDTO> updateRooms(Long hotelId, List<RoomDTO> roomDTOs) {
		Hotel hotel = hotelRepository.findById(hotelId)
				.orElseThrow(() -> new RuntimeException("Hotel not found with id: " + hotelId));

		Map<Long, Room> existingRoomsMap = hotel.getRooms().stream()
				.collect(Collectors.toMap(Room::getId, Function.identity()));

		Set<Long> updatedRoomIds = new HashSet<>();
		List<RoomDTO> updatedRoomDTOs = new ArrayList<>();

		if (roomDTOs != null) {
			for (RoomDTO roomDTO : roomDTOs) {
				Room room;
				if (roomDTO.getId() != null && existingRoomsMap.containsKey(roomDTO.getId())) {
					// Update existing room
					room = existingRoomsMap.get(roomDTO.getId());
					mapToRoomEntity(roomDTO, room);
					updatedRoomIds.add(roomDTO.getId());
				} else {
					// Add new room
					RoomType roomType = roomTypeRepository.findById(roomDTO.getRoomTypeId())
							.orElseThrow(() -> new RuntimeException("RoomType not found with id: " + roomDTO.getRoomTypeId()));
					room = new Room();
					mapToRoomEntity(roomDTO, room);
					room.setHotel(hotel);
					room.setRoomType(roomType);
					roomRepository.save(room);
					hotel.getRooms().add(room);
					updatedRoomIds.add(room.getId());
				}

				// Update room facilities
				updateRoomFacilities(room, roomDTO.getRoomFacilities());

				// Map updated room back to RoomDTO and add to result list
				updatedRoomDTOs.add(mapToRoomDTO(room));
			}
		}

		// Handle rooms not included in the update
		hotel.getRooms().removeIf(room -> !updatedRoomIds.contains(room.getId()) && room.getListBooking().isEmpty());

		return updatedRoomDTOs;
	}

	private void updateRoomFacilities (Room room, List<RoomFacilityDTO> roomFacilityDTOs) {
		List<RoomFacility> existedList = roomFacilityRepository.findByRoom(room);
		roomFacilityRepository.deleteAll(existedList);

		if (roomFacilityDTOs != null)
		{
			for (RoomFacilityDTO roomFacilityDTO : roomFacilityDTOs)
			{
				Facility facility = facilityRepository.findById(roomFacilityDTO.getFacilityId()).orElseThrow(
						() -> new RuntimeException("Facility not found with id: " + roomFacilityDTO.getFacilityId()));
				RoomFacility roomFacility = new RoomFacility();
				roomFacility.setRoom(room);
				roomFacility.setFacility(facility);
				roomFacilityRepository.save(roomFacility);
			}
		}
	}

	private void mapToRoomEntity (RoomDTO roomDTO, Room room) {
		room.setCapacity(roomDTO.getCapacity());
		room.setPrice(roomDTO.getPrice());
		room.setQuantity(roomDTO.getQuantity());
		room.setRoomSize(roomDTO.getRoomSize());
		room.setDescription(roomDTO.getDescription());
		room.setServeBreakfast(roomDTO.isServeBreakfast());
	}

	private RoomDTO mapToRoomDTO(Room room) {
		RoomDTO roomDTO = new RoomDTO();
		roomDTO.setId(room.getId());
		roomDTO.setCapacity(room.getCapacity());
		roomDTO.setPrice(room.getPrice());
		roomDTO.setQuantity(room.getQuantity());
		roomDTO.setRoomSize(room.getRoomSize());
		roomDTO.setDescription(room.getDescription());
		roomDTO.setRoomTypeId(room.getRoomType().getId());
		roomDTO.setServeBreakfast(room.isServeBreakfast());
		roomDTO.setHotelId(room.getHotel().getId());

		List<RoomFacilityDTO> roomFacilityDTOs = room.getRoomFacilities().stream()
				.map(rf -> new RoomFacilityDTO(rf.getFacility().getFacId()))
				.collect(Collectors.toList());
		roomDTO.setRoomFacilities(roomFacilityDTOs);

		return roomDTO;
	}
}
