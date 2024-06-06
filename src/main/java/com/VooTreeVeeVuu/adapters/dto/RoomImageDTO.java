package com.VooTreeVeeVuu.adapters.dto;

import com.VooTreeVeeVuu.domain.entity.Room;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomImageDTO {
	private Long id;
	private String path;
	private Room room;
}
