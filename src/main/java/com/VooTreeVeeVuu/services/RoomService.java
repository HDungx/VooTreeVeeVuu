package com.VooTreeVeeVuu.services;

import com.VooTreeVeeVuu.domain.entity.*;
import com.VooTreeVeeVuu.domain.repository.*;
import com.VooTreeVeeVuu.domain.utils.Hotel_status;
import com.VooTreeVeeVuu.dto.RoomDTO;
import com.VooTreeVeeVuu.dto.RoomFacilityDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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
    public RoomDTO updateRooms(Long roomId, RoomDTO roomDTO) {
        Room existedRoom = roomRepository.findById(roomId).orElseThrow(
                () -> new RuntimeException("Room not found with id: " + roomId));
        updateRoomEntity(existedRoom, roomDTO);
        Room updatedRoom = roomRepository.save(existedRoom);

        Hotel hotel = hotelRepository.findById(existedRoom.getHotel().getId()).orElseThrow(() -> new RuntimeException("Hotel not found"));
        hotel.setStatus(Hotel_status.PENDING);
        hotelRepository.save(hotel);

        updateRoomFacilities(updatedRoom, roomDTO.getRoomFacilities());

        return mapToRoomDTO(updatedRoom);
    }

    private void updateRoomEntity(Room room, RoomDTO roomDTO) {
        room.setCapacity(roomDTO.getCapacity());
        room.setPrice(roomDTO.getPrice());
        room.setQuantity(roomDTO.getQuantity());
        room.setRoomSize(roomDTO.getRoomSize());
        room.setDescription(roomDTO.getDescription());
        room.setServeBreakfast(roomDTO.isServeBreakfast());

        if (roomDTO.getRoomTypeId() != null) {
            RoomType roomType = roomTypeRepository.findById(roomDTO.getRoomTypeId())
                    .orElseThrow(() -> new RuntimeException("RoomType not found with id: " + roomDTO.getRoomTypeId()));
            room.setRoomType(roomType);
        }

        // Update associations with existing Hotel
        if (roomDTO.getHotelId() != null) {
            Hotel hotel = hotelRepository.findById(roomDTO.getHotelId())
                    .orElseThrow(() -> new RuntimeException("Hotel not found with id: " + roomDTO.getHotelId()));
            room.setHotel(hotel);
        }

        // Update Room Facilities
        //updateRoomFacilities(room, roomDTO.getRoomFacilities());
    }

    private void updateRoomFacilities(Room room, List<RoomFacilityDTO> roomFacilityDTOs) {
//        List<RoomFacility> existedList = roomFacilityRepository.findByRoom(room);
//
//        roomFacilityRepository.deleteAll(existedList);

        room.getRoomFacilities().clear();

        if (roomFacilityDTOs != null) {
            for (RoomFacilityDTO roomFacilityDTO : roomFacilityDTOs) {
                Facility facility = facilityRepository.findById(roomFacilityDTO.getFacilityId()).orElseThrow(
                        () -> new RuntimeException("Facility not found with id: " + roomFacilityDTO.getFacilityId()));
                RoomFacility roomFacility = new RoomFacility();
                roomFacility.setRoom(room);
                roomFacility.setFacility(facility);
                roomFacilityRepository.save(roomFacility);
            }
        }
    }

    private void mapToRoomEntity(RoomDTO roomDTO, Room room) {
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

        roomDTO.setRoomFacilities(room.getRoomFacilities().stream().map(
                rf -> {
                    RoomFacilityDTO facilityDTO = new RoomFacilityDTO();
                    facilityDTO.setFacilityId(rf.getFacility().getFacId());
                    return facilityDTO;
                }
        ).collect(Collectors.toList()));

        return roomDTO;
    }
}
