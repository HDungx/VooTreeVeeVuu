package com.VooTreeVeeVuu.controller;

import com.VooTreeVeeVuu.dto.GetAllHotelDTO;
import com.VooTreeVeeVuu.dto.HotelDTO;
import com.VooTreeVeeVuu.dto.HotelImageDTO;
import com.VooTreeVeeVuu.services.HotelService;
import com.VooTreeVeeVuu.usecase.HotelUsecase.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin ("*")
@RestController
@RequestMapping ("/api/hotels")
public class HotelController {
	@Autowired
	private GetAllHotelUseCase getAllHotelUseCase;

	@Autowired
	private GetHotelUseCase getHotelUseCase;

	@Autowired
	private DeleteHotelUseCase deleteHotelUseCase;

	@Autowired
	private UpdateStatusHotelUseCase updateStatusHotelUseCase;

	@Autowired
	private ImagesUploadUseCase imagesUploadUseCase;

	@Autowired
	private HotelService hotelService;

	@GetMapping ()
	public List<GetAllHotelDTO> getAllHotel () {
		return getAllHotelUseCase.getAllHotel();
	}

	@GetMapping ("/{id}")
	public Optional<GetAllHotelDTO> getHotelById (@PathVariable Long id) {
		return getHotelUseCase.getHotelById(id);
	}

	@PostMapping
	public ResponseEntity<HotelDTO> createHotel (@RequestBody @Valid HotelDTO hotelDTO) {
		HotelDTO createdHotel = hotelService.createHotel(hotelDTO);
		return new ResponseEntity<>(createdHotel, HttpStatus.CREATED);
	}

	@PutMapping ("/{id}")
	public ResponseEntity<HotelDTO> updateHotel (@PathVariable Long id, @RequestBody @Valid HotelDTO hotelDTO) {
		HotelDTO updatedHotel = hotelService.updateHotel(id, hotelDTO);
		return new ResponseEntity<>(updatedHotel, HttpStatus.OK);
	}

	@PostMapping ("/{id}/images")
	public ResponseEntity<HotelDTO> addImage (@PathVariable Long id, @RequestBody List<HotelImageDTO> imageDTO) {
		Optional<HotelDTO> updated = imagesUploadUseCase.uploadImg(id, imageDTO);
		return updated.map(ResponseEntity :: ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
}
