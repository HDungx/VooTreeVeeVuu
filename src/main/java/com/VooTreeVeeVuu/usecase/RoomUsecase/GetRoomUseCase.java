package com.VooTreeVeeVuu.usecase.RoomUsecase;

import com.VooTreeVeeVuu.adapters.dto.RoomDTO;
import com.VooTreeVeeVuu.domain.entity.Room;
import com.VooTreeVeeVuu.domain.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetRoomUseCase {
//    @Autowired
//    private RoomRepository roomRepository;
//
//    public Optional<RoomDTO> getRoomById(Long id){
//        return roomRepository.findById(id).map(this :: toDTO);
//    }
//    private RoomDTO toDTO(Room room) {
//        RoomDTO dto = new RoomDTO();
//        dto.setId(room.getId());
//        dto.setCapacity(room.getCapacity());
//        dto.setPrice(room.getPrice());
//        dto.setQuantity(room.getQuantity());
//        dto.setRoomSize(room.getRoomSize());
//        dto.setDescription(room.getDescription());
//        dto.setRoomType(room.getRoomType());
//        dto.setHotel(room.getHotel());
//        dto.setRoomFacilities(room.getRoomFacilities());
//        dto.setRoom_images(room.getRoom_images());
//        dto.setListBooking(room.getListBooking());
//        return dto;
//    }
}
