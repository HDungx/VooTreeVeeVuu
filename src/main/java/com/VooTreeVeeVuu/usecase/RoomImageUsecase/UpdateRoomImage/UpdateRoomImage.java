package com.VooTreeVeeVuu.usecase.RoomImageUsecase.UpdateRoomImage;

import com.VooTreeVeeVuu.dto.RoomImageDTO;

import java.util.Optional;

public interface UpdateRoomImage {
	Optional<RoomImageDTO> updateRoomImage (Long id, RoomImageDTO roomImageDTO);
}
