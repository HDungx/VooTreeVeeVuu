package com.VooTreeVeeVuu.services;

import com.VooTreeVeeVuu.entity.Room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface RoomServ {
	public Page<Room> getAll (Pageable pageable);

	public Optional<Room> findById (String id);

	public Room save (Room room);

	public void delete (String id);
}
