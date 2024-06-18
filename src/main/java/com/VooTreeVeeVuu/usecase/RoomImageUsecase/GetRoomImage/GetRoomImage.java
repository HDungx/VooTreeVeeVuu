package com.VooTreeVeeVuu.usecase.RoomImageUsecase.GetRoomImage;

import com.VooTreeVeeVuu.dto.RoomImageDTO;

import java.util.Optional;

public interface GetRoomImage {
	Optional<RoomImageDTO> getRoomImageById(Long id);
}
