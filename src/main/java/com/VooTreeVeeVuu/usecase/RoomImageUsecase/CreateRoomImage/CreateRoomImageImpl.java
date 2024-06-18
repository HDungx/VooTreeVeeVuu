package com.VooTreeVeeVuu.usecase.RoomImageUsecase.CreateRoomImage;


import com.VooTreeVeeVuu.dto.RoomImageDTO;
import com.VooTreeVeeVuu.domain.entity.RoomImage;
import com.VooTreeVeeVuu.domain.repository.RoomImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreateRoomImageImpl implements CreateRoomImage {
    @Autowired
    private RoomImageRepository roomImageRepository;

    @Transactional
    public RoomImageDTO createRoomImage (RoomImageDTO roomImageDTO){
        RoomImage roomImage = toEntity(roomImageDTO);
        RoomImage saved = roomImageRepository.save(roomImage);
        return toDTO(saved);
    }

    private RoomImageDTO toDTO(RoomImage roomImage) {
        RoomImageDTO dto = new RoomImageDTO();
        dto.setPath(roomImage.getPath());
        dto.setRoom(roomImage.getRoom());
        return dto;
    }

    private RoomImage toEntity(RoomImageDTO roomImageDTO) {
        RoomImage roomImage = new RoomImage();
        roomImage.setPath(roomImageDTO.getPath());
        roomImage.setRoom(roomImageDTO.getRoom());
        return roomImage;
    }
}
