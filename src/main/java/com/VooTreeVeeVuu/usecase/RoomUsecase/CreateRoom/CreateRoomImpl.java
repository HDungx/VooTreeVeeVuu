//package com.VooTreeVeeVuu.usecase.RoomUsecase.CreateRoom;
//
//import com.VooTreeVeeVuu.domain.entity.Room;
//import com.VooTreeVeeVuu.dto.RoomDTO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//@Service
//public class CreateRoomImpl implements CreateRoom {
//    @Autowired
//
////    @Transactional
////    public RoomDTO createRoom(RoomDTO roomDTO) {
////
////    }
//
//    private RoomDTO toDTO(Room room) {
//        RoomDTO dto = new RoomDTO();
//        dto.setRoomSize(dto.getRoomSize());
//        dto.setDescription(dto.getDescription());
//        dto.setRoomFacilities(dto.getRoomFacilities());
//        dto.setQuantity(dto.getQuantity());
//        dto.setPrice(dto.getPrice());
//        dto.setCapacity(dto.getCapacity());
//        dto.setRoomTypeId(dto.getRoomTypeId());
//        dto.setServeBreakfast(dto.isServeBreakfast());
//
//        return dto;
//    }
//
//    private Room toEntity(RoomDTO roomDTO) {
//        Room room = new Room();
//        room.setRoomSize(roomDTO.getRoomSize());
//        room.setDescription(roomDTO.getDescription());
//        room.setRoomFacilities(roomDTO.getRoomFacilities());
//        room.setQuantity(roomDTO.getQuantity());
//        room.setPrice(roomDTO.getPrice());
//        room.setCapacity(roomDTO.getCapacity());
//        room.setRoomTypeId(roomDTO.getRoomTypeId());
//        room.setServeBreakfast(roomDTO.isServeBreakfast());
//        return rating;
//    }
//}
