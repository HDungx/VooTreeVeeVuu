package com.VooTreeVeeVuu.controller;

import com.VooTreeVeeVuu.entity.Room;
import com.VooTreeVeeVuu.repository.RoomFacilityRepository;
import com.VooTreeVeeVuu.servicesImp.RoomServImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin ("*")
@RestController
@RequestMapping ("/api/rooms")
public class RoomController {
	@Autowired
	RoomServImp roomServImp;
	@Autowired
	private RoomFacilityRepository roomFacilityRepository;

//	@GetMapping ()
//	public Page<Room> getAllRooms (@RequestParam (defaultValue = "0") int page,
//	                               @RequestParam (defaultValue = "10") int size,
//	                               @RequestParam (defaultValue = "roomId") String sortBy,
//	                               @RequestParam (defaultValue = "asc") String dir) {
//		Sort sort = dir.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
//		Pageable pageable = PageRequest.of(page, size, sort);
//		return roomServImp.getAll(pageable);
//	}

	@GetMapping ()
	public ResponseEntity<List<Room>> getAllRooms () {
		return new ResponseEntity<>(roomServImp.getAll(), HttpStatus.OK);
	}

	@GetMapping ("/{id}")
	public ResponseEntity<Room> getRoomById (@PathVariable String id) {
		return roomServImp.findById(id).map(r -> new ResponseEntity<>(r, HttpStatus.OK)).orElse(
				new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@PostMapping
	public ResponseEntity<Room> createRoom (@RequestBody Room room) {
		return new ResponseEntity<>(roomServImp.save(room), HttpStatus.CREATED);
	}

	@PutMapping ("/update/{id}")
	public ResponseEntity<Room> updateRoom (@RequestBody Room room, @PathVariable String id) {
		return roomServImp.findById(id).map(r -> {
			r.setCapacity(room.getCapacity());
			r.setPrice(room.getPrice());
			r.setQuantity(room.getQuantity());
			r.setRoomSize(room.getRoomSize());
			r.setDescription(room.getDescription());
			r.setRoomType(room.getRoomType());
			r.setHotel(room.getHotel());
			r.setRoom_images(room.getRoom_images());
			return new ResponseEntity<>(r, HttpStatus.OK);
		}).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@DeleteMapping ("/delete/{id}")
	public ResponseEntity<Void> deleteRoom (@PathVariable String id) {
		return roomServImp.findById(id).map(r -> {
			roomServImp.delete(id);
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
}
