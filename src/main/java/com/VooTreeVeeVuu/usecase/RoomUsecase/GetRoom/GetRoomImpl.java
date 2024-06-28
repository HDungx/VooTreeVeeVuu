package com.VooTreeVeeVuu.usecase.RoomUsecase.GetRoom;

import com.VooTreeVeeVuu.domain.entity.Room;
import com.VooTreeVeeVuu.domain.repository.RoomRepository;
import com.VooTreeVeeVuu.dto.GetAllRoomDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetRoomImpl implements GetRoom {
    @Autowired
    private RoomRepository roomRepository;

    public GetAllRoomDTO getRoomById(Long id) {
        return roomRepository.findById(id).map(this::toDTO).orElseThrow(() -> new RuntimeException("Room not found"));
    }

    private GetAllRoomDTO toDTO(Room room) {
        GetAllRoomDTO dto = new GetAllRoomDTO();
        dto.setId(room.getId());
        dto.setCapacity(room.getCapacity());
        dto.setPrice(room.getPrice());
        dto.setQuantity(room.getQuantity());
        dto.setRoomSize(room.getRoomSize());
        dto.setDescription(room.getDescription());
        dto.setRoomType(room.getRoomType());
        dto.setHotel(room.getHotel());
        dto.setOwnerEmail(room.getHotel().getUser().getAccount().getEmail());
        dto.setRoomFacilities(room.getRoomFacilities());
        dto.setRoom_images(room.getRoom_images());
        //dto.setListBooking(room.getListBooking());
        dto.setServeBreakfast(room.isServeBreakfast());
        return dto;
    }
}
