package com.VooTreeVeeVuu.adapters.controller;

import com.VooTreeVeeVuu.adapters.dto.HotelDTO;
import com.VooTreeVeeVuu.adapters.dto.HotelImageDTO;
import com.VooTreeVeeVuu.adapters.dto.HotelWithDetailsDTO;
import com.VooTreeVeeVuu.domain.entity.HotelImage;
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
	private CreateHotelUseCase createHotelUseCase;

	@Autowired
	private UpdateHotelUseCase updateHotelUseCase;

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
	public List<HotelDTO> getAllHotel () {
		return getAllHotelUseCase.getAllHotel();
	}

	@GetMapping ("/{id}")
	public Optional<HotelDTO> getHotelById (@PathVariable Long id) {
		return getHotelUseCase.getHotelById(id);
	}

//	@PostMapping
//	public HotelDTO createHotel (@RequestBody HotelDTO dto) {
//		return createHotelUseCase.createHotel(dto);
//	}

	@PostMapping
	public ResponseEntity<HotelDTO> createHotel(@RequestBody @Valid HotelDTO hotelDTO) {
		HotelDTO createdHotel = hotelService.createHotel(hotelDTO);
		return new ResponseEntity<>(createdHotel, HttpStatus.CREATED);
	}

//	@PutMapping ("/partner/update/{id}")
//	public Optional<HotelDTO> updateHotel (@RequestBody HotelDTO dto, @PathVariable Long id) {
//		return updateHotelUseCase.updateHotelDTO(id, dto);
//	}

	@PutMapping ("/staff/update/{id}")
	public Optional<HotelDTO> updateStatusHotel (@RequestBody HotelDTO dto, @PathVariable Long id) {
		return updateStatusHotelUseCase.updateStatusHotel(id, dto);
	}

	@DeleteMapping ("/delete/{id}")
	public void deleteHotel (@PathVariable Long id) {
		deleteHotelUseCase.deleteHotel(id);
	}

	@PostMapping ("/{id}/images")
	public ResponseEntity<HotelDTO> addImage (@PathVariable Long id, @RequestBody List<HotelImageDTO> imageDTO) {
		Optional<HotelDTO> updated = imagesUploadUseCase.uploadImg(id, imageDTO);
		return updated.map(ResponseEntity :: ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
}
