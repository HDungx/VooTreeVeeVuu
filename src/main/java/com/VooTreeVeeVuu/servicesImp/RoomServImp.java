package com.VooTreeVeeVuu.servicesImp;

import com.VooTreeVeeVuu.entity.Room;
import com.VooTreeVeeVuu.repository.RoomRepository;
import com.VooTreeVeeVuu.services.RoomServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoomServImp implements RoomServ {
	@Autowired
	RoomRepository roomRepository;

	@Override
	public Page<Room> getAll (Pageable pageable) {
		return roomRepository.findAll(pageable);
	}

	@Override
	public Optional<Room> findById (String id) {
		return roomRepository.findById(id);
	}

	@Override
	public Room save (Room room) {
		return roomRepository.save(room);
	}

	@Override
	public void delete (String id) {
		roomRepository.deleteById(id);
	}
}
