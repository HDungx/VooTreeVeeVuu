package com.VooTreeVeeVuu.usecase.RoomUsecase;


import com.VooTreeVeeVuu.adapters.dto.RoomDTO;
import com.VooTreeVeeVuu.domain.entity.Room;
import com.VooTreeVeeVuu.domain.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UpdateRoomUseCase {
    @Autowired
    private RoomRepository roomRepository;

    @Transactional
    public Optional<RoomDTO> updateRooms(Long id, RoomDTO roomDTO){
        return roomRepository.findById(id).map(room -> {
            room.setCapacity(roomDTO.getCapacity());
            room.setPrice(roomDTO.getPrice());
            room.setQuantity(roomDTO.getQuantity());
            room.setRoomSize(roomDTO.getRoomSize());
            room.setDescription(roomDTO.getDescription());
            room.setRoomType(roomDTO.getRoomType());
            room.setHotel(roomDTO.getHotel());
            room.setRoomFacilities(roomDTO.getRoomFacilities());
            room.setRoom_images(roomDTO.getRoom_images());
            Room updated = roomRepository.save(room);
            return toDTO(updated);
        });
    }
    private RoomDTO toDTO(Room room) {
        RoomDTO dto = new RoomDTO();
        dto.setId(room.getId());
        dto.setCapacity(room.getCapacity());
        dto.setPrice(room.getPrice());
        dto.setQuantity(room.getQuantity());
        dto.setRoomSize(room.getRoomSize());
        dto.setDescription(room.getDescription());
        dto.setRoomType(room.getRoomType());
        dto.setHotel(room.getHotel());
        dto.setRoomFacilities(room.getRoomFacilities());
        dto.setRoom_images(room.getRoom_images());
        return dto;
    }
}
