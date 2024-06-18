package com.VooTreeVeeVuu.controller;

import com.VooTreeVeeVuu.dto.GetAllHotelDTO;
import com.VooTreeVeeVuu.dto.HotelDTO;
import com.VooTreeVeeVuu.dto.HotelImageDTO;
import com.VooTreeVeeVuu.services.HotelService;
import com.VooTreeVeeVuu.usecase.HotelUsecase.DeleteHotel.DeleteHotelImpl;
import com.VooTreeVeeVuu.usecase.HotelUsecase.GetAllHotel.GetAllHotelImpl;
import com.VooTreeVeeVuu.usecase.HotelUsecase.GetHotel.GetHotelImpl;
import com.VooTreeVeeVuu.usecase.HotelUsecase.ImagesUpload.ImagesUploadImpl;
import com.VooTreeVeeVuu.usecase.HotelUsecase.UpdateStatusHotel.UpdateStatusHotelImpl;
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
	private GetAllHotelImpl getAllHotelUseCase;

	@Autowired
	private GetHotelImpl getHotelUseCase;

	@Autowired
	private DeleteHotelImpl deleteHotelUseCase;

	@Autowired
	private UpdateStatusHotelImpl updateStatusHotelUseCase;

	@Autowired
	private ImagesUploadImpl imagesUploadUseCase;

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

	@PutMapping ("/partner/update/{id}")
	public ResponseEntity<HotelDTO> updatePartnerHotel (@PathVariable Long id, @RequestBody @Valid HotelDTO hotelDTO) {
		HotelDTO updatedHotel = hotelService.updateHotel(id, hotelDTO);
		return new ResponseEntity<>(updatedHotel, HttpStatus.OK);
	}

	@PutMapping ("/staff/update/{id}")
	public Optional<GetAllHotelDTO> updateHotel (@RequestBody GetAllHotelDTO dto, @PathVariable Long id) {
		return updateStatusHotelUseCase.updateStatusHotel(id, dto);
	}

	@DeleteMapping ("/{id}")
	public ResponseEntity<Void> deleteHotel (@PathVariable Long id) {
		hotelService.deleteHotel(id);
		return ResponseEntity.noContent().build();
	}

	@PostMapping ("/{id}/images")
	public ResponseEntity<HotelDTO> addImage (@PathVariable Long id, @RequestBody List<HotelImageDTO> imageDTO) {
		Optional<HotelDTO> updated = imagesUploadUseCase.uploadImg(id, imageDTO);
		return updated.map(ResponseEntity :: ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
}
