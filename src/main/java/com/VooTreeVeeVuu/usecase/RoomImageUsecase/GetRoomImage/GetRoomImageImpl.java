package com.VooTreeVeeVuu.usecase.RoomImageUsecase.GetRoomImage;

import com.VooTreeVeeVuu.dto.RoomImageDTO;
import com.VooTreeVeeVuu.domain.entity.RoomImage;
import com.VooTreeVeeVuu.domain.repository.RoomImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetRoomImageImpl implements GetRoomImage{
    @Autowired
    private RoomImageRepository roomImageRepository;

    public Optional<RoomImageDTO> getRoomImageById(Long id){
        return roomImageRepository.findById(id).map(this :: toDTO);
    }

    private RoomImageDTO toDTO(RoomImage roomImage) {
        RoomImageDTO dto = new RoomImageDTO();
        dto.setId(roomImage.getId());
        dto.setPath(roomImage.getPath());
        dto.setRoom(roomImage.getRoom());
        return dto;
    }
}
