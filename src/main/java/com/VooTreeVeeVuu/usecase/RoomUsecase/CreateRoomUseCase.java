package com.VooTreeVeeVuu.usecase.RoomUsecase;

import com.VooTreeVeeVuu.adapters.dto.RoomDTO;
import com.VooTreeVeeVuu.domain.entity.Hotel;
import com.VooTreeVeeVuu.domain.entity.Room;
import com.VooTreeVeeVuu.domain.entity.RoomType;
import com.VooTreeVeeVuu.domain.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreateRoomUseCase {
//    @Autowired
//    private RoomRepository roomRepository;
//
//    @Transactional
//    public RoomDTO createRoom(RoomDTO roomDTO){
//        Room room = toEntity(roomDTO);
//        Room saved = roomRepository.save(room);
//        return toDTO(saved);
//    }
//
//    private RoomDTO toDTO(Room room) {
//        RoomDTO dto = new RoomDTO();
//        //dto.setId(room.getId());
//        dto.setCapacity(room.getCapacity());
//        dto.setPrice(room.getPrice());
//        dto.setQuantity(room.getQuantity());
//        dto.setRoomSize(room.getRoomSize());
//        dto.setDescription(room.getDescription());
//        dto.setRoomTypeId(room.getRoomType().getId());
//        //dto.setHotel(room.getHotel());
//        //dto.setRoomFacilities(room.getRoomFacilities());
//        //dto.setRoom_images(room.getRoom_images());
//        //dto.setListBooking(room.getListBooking());
//        return dto;
//    }
//
//    private Room toEntity(RoomDTO roomDTO, Hotel hotel) {
//        Room room = new Room();
//        room.setCapacity(roomDTO.getCapacity());
//        room.setPrice(roomDTO.getPrice());
//        room.setQuantity(roomDTO.getQuantity());
//        room.setRoomSize(roomDTO.getRoomSize());
//        room.setDescription(roomDTO.getDescription());
//        room.setServeBreakfast(roomDTO.isServeBreakfast());
//        room.setHotel(hotel);
//        room.setRoomType(new RoomType(roomDTO.getRoomTypeId()));
//        return room;
//    }


}
