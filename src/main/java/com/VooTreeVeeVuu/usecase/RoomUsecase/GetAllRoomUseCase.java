package com.VooTreeVeeVuu.usecase.RoomUsecase;


import com.VooTreeVeeVuu.adapters.dto.RoomDTO;
import com.VooTreeVeeVuu.domain.entity.Room;
import com.VooTreeVeeVuu.domain.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class GetAllRoomUseCase {
    @Autowired
    private RoomRepository roomRepository;

    public List<RoomDTO> getAllRoom(){
        return roomRepository.findAll().stream().map(this :: toDTO).collect(Collectors.toList());
    }

    private RoomDTO toDTO(Room room) {
        RoomDTO dto = new RoomDTO();
        //dto.setId(room.getId());
        dto.setCapacity(room.getCapacity());
        dto.setPrice(room.getPrice());
        dto.setQuantity(room.getQuantity());
        dto.setRoomSize(room.getRoomSize());
        dto.setDescription(room.getDescription());
        dto.setRoomTypeId(room.getRoomType().getId());
        //dto.setHotel(room.getHotel());
        //dto.setRoomFacilities(room.getRoomFacilities());
        //dto.setRoom_images(room.getRoom_images());
        //dto.setListBooking(room.getListBooking());
        return dto;
    }
}
