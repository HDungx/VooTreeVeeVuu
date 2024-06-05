package com.VooTreeVeeVuu.services;

import com.VooTreeVeeVuu.domain.entity.Room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface RoomServ {
	public Page<Room> getAll (Pageable pageable);

	public List<Room> getAll ();

	public Optional<Room> findById (String id);

	public Room save (Room room);

	public void delete (String id);
}
