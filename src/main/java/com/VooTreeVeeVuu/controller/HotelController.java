package com.VooTreeVeeVuu.controller;

import com.VooTreeVeeVuu.domain.entity.Hotel;
import com.VooTreeVeeVuu.domain.repository.HotelRepository;
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
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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
	@Autowired
	private HotelRepository hotelRepository;

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

	//	@GetMapping ("/search")
//	public ResponseEntity<List<GetAllHotelDTO>> searchHotels (
//			@RequestParam (value = "searchTerm", required = true) String searchTerm,
//			@RequestParam (value = "capacity") Integer capacity, @RequestParam (value = "checkIn") LocalDate checkIn,
//			@RequestParam (value = "checkOut") LocalDate checkOut,
//			@RequestParam (value = "quantity") Integer quantity) {
//		try
//		{
//			List<GetAllHotelDTO> hotels = hotelService.searchHotels(searchTerm, capacity, checkIn, checkOut, quantity);
//			return new ResponseEntity<>(hotels, HttpStatus.OK);
//		} catch (Exception e)
//		{
//			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}
	@GetMapping ("/search")
	public ResponseEntity<List<GetAllHotelDTO>> searchHotels (@RequestParam (required = false) String hotelName,
	                                                          @RequestParam (required = false) String city,
	                                                          @RequestParam @DateTimeFormat (iso = DateTimeFormat.ISO.DATE) LocalDate checkinDate,
	                                                          @RequestParam @DateTimeFormat (iso = DateTimeFormat.ISO.DATE) LocalDate checkoutDate,
	                                                          @RequestParam int rooms, @RequestParam int capacity) {

		// Kiểm tra tính hợp lệ của ngày
		if (!hotelService.validateDates(checkinDate, checkoutDate))
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}

		// Kiểm tra xem ít nhất một trong hai tham số hotelName hoặc city phải có giá trị
		if ((hotelName == null || hotelName.isEmpty()) && (city == null || city.isEmpty()))
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}

		// Tìm kiếm các khách sạn
		List<GetAllHotelDTO> hotels;
		try
		{
			hotels = hotelService.searchHotels(hotelName, city, checkinDate, checkoutDate, rooms, capacity);
		} catch (IllegalArgumentException e)
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}

		if (hotels.isEmpty())
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}

		return ResponseEntity.ok(hotels);
	}
}
