package com.VooTreeVeeVuu.usecase.RoomUsecase.GetRoom;

import com.VooTreeVeeVuu.dto.GetAllRoomDTO;

import java.util.Optional;

public interface GetRoom {
	Optional<GetAllRoomDTO> getRoomById(Long id);
}
