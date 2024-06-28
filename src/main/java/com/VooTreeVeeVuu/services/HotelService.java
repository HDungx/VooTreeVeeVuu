package com.VooTreeVeeVuu.services;

import com.VooTreeVeeVuu.domain.entity.*;
import com.VooTreeVeeVuu.domain.repository.*;
import com.VooTreeVeeVuu.dto.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HotelService {
	@Autowired
	private HotelRepository hotelRepository;

	@Autowired
	private HotelFacilityRepository hotelFacilityRepository;

	@Autowired
	private RoomRepository roomRepository;

	@Autowired
	private RoomTypeRepository roomTypeRepository;

	@Autowired
	private FacilityRepository facilityRepository;

	@Autowired
	private RoomFacilityRepository roomFacilityRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private HotelImageRepository hotelImageRepository;

	public GetAllHotelDTO saveHotelImages (Long hotelId, List<MultipartFile> files) throws IOException {
		Hotel hotel = hotelRepository.findById(hotelId).orElseThrow(() -> new RuntimeException("Hotel not found"));

		List<HotelImage> images = new ArrayList<>();
		for (MultipartFile file : files)
		{
			HotelImage hotelImage = new HotelImage();
			hotelImage.setImageName(file.getOriginalFilename());
			hotelImage.setImageBase64(file.getBytes());
			hotelImage.setImageType(file.getContentType());
			hotelImage.setHotel(hotel);
			images.add(hotelImage);
		}
		hotel.getHotelImages().addAll(images);
		hotelImageRepository.saveAll(images);
		Hotel saved = hotelRepository.save(hotel);
		return toDTO(saved);
	}

	public List<GetAllHotelDTO> getAllHotelByUser (Long id) {
		//User partner = userRepository.findById(user.getId()).orElseThrow(() -> new RuntimeException("Partner not found"));
		return hotelRepository.findByUserId(id).stream().map(this :: toDTO).collect(Collectors.toList());
	}

	public HotelDTO createHotel (HotelDTO hotelDTO) {
		Hotel hotel = mapToHotelEntity(hotelDTO);
		Hotel savedHotel = hotelRepository.save(hotel);

		if (hotelDTO.getHotelFacilities() != null)
		{
			for (HotelFacilityDTO facilityDTO : hotelDTO.getHotelFacilities())
			{
				HotelFacility hotelFacility = new HotelFacility();
				hotelFacility.setHotel(savedHotel);
				hotelFacility.setFacility(new Facility(facilityDTO.getFacilityId()));
				hotelFacilityRepository.save(hotelFacility);
			}
		}

		if (hotelDTO.getRooms() != null)
		{
			for (RoomDTO roomDTO : hotelDTO.getRooms())
			{
				RoomType roomType = roomTypeRepository.findById(roomDTO.getRoomTypeId()).orElseThrow(
						() -> new RuntimeException("RoomType not found with id: " + roomDTO.getRoomTypeId()));
				Room room = mapToRoomEntity(roomDTO, savedHotel, roomType);
				roomRepository.save(room);
				if (roomDTO.getRoomFacilities() != null)
				{
					for (RoomFacilityDTO roomFacilityDTO : roomDTO.getRoomFacilities())
					{
						Facility facility = facilityRepository.findById(roomFacilityDTO.getFacilityId()).orElseThrow(
								() -> new RuntimeException(
										"Facility not found with id: " + roomFacilityDTO.getFacilityId()));
						RoomFacility roomFacility = new RoomFacility();
						roomFacility.setRoom(room);
						roomFacilityRepository.save(roomFacility);
					}
					roomRepository.save(room);
				}
			}
		}
		return mapToHotelDTO(savedHotel);
	}

	@Transactional
	public HotelDTO updateHotel (Long hotelId, HotelDTO hotelDTO) {
		Hotel existingHotel = hotelRepository.findById(hotelId).orElseThrow(
				() -> new RuntimeException("Hotel not found with id: " + hotelId));
		updateHotelEntity(existingHotel, hotelDTO);
		Hotel updatedHotel = hotelRepository.save(existingHotel);

		updateHotelFacilities(updatedHotel, hotelDTO.getHotelFacilities());

		return mapToHotelDTO(updatedHotel);
	}

	@Transactional
	public void deleteHotel (Long id) {
		Hotel existed = hotelRepository.findById(id).orElseThrow(() -> new RuntimeException("Hotel not found"));

		existed.getRooms().forEach(room -> {
			roomFacilityRepository.deleteAll(room.getRoomFacilities());
		});

		roomRepository.deleteAll(existed.getRooms());

		hotelFacilityRepository.deleteAll(existed.getHotelFacilities());

		hotelRepository.delete(existed);
	}

	public List<GetAllHotelDTO> searchHotels (String hotelName, String city, LocalDate checkinDate,
	                                          LocalDate checkoutDate, int rooms, int capacity) {
		List<Hotel> hotels;


		if (hotelName != null && !hotelName.isEmpty() && city != null && !city.isEmpty())
		{
			hotels = hotelRepository.findByHotelNameOrCity(hotelName, city);
		} else
		{
			throw new IllegalArgumentException("Either hotelName or city must be provided.");
		}

		// Lọc các khách sạn dựa trên số lượng phòng trống, sức chứa và ngày, sau đó chuyển đổi thành DTO
		return hotels.stream().map(hotel -> {
					hotel.setRooms(filterRooms(hotel.getRooms(), checkinDate, checkoutDate, rooms, capacity));
					return hotel;
				}).filter(hotel -> !hotel.getRooms().isEmpty()) // Chỉ giữ khách sạn có phòng thỏa mãn điều kiện
				.map(this :: toDTO).collect(Collectors.toList());
	}

	// Lấy chi tiết khách sạn và lọc theo tiêu chí tìm kiếm
	public GetAllHotelDTO getHotelByIdWithCriteria (Long id, LocalDate checkinDate, LocalDate checkoutDate, int rooms,
	                                                int capacity) {
		Hotel hotel = hotelRepository.findById(id).orElseThrow(
				() -> new IllegalArgumentException("Hotel not found with id: " + id));

		// Lọc các phòng dựa trên tiêu chí tìm kiếm
		hotel.setRooms(filterRooms(hotel.getRooms(), checkinDate, checkoutDate, rooms, capacity));

		return toDTO(hotel);
	}

	private List<Room> filterRooms (List<Room> rooms, LocalDate checkinDate, LocalDate checkoutDate, int requiredRooms,
	                                int capacity) {
		return rooms.stream().filter(room -> room.getCapacity() >= capacity).filter(
				room -> getAvailableRooms(room, checkinDate, checkoutDate) >= requiredRooms).collect(
				Collectors.toList());
	}

	private int getAvailableRooms (Room room, LocalDate checkinDate, LocalDate checkoutDate) {
		long bookedRooms = room.getListBooking().stream().filter(
				booking -> booking.getCheckInDate().isBefore(checkoutDate) && booking.getCheckOutDate().isAfter(
						checkinDate)).count();
		return room.getQuantity() - (int) bookedRooms;
	}

	public boolean validateDates (LocalDate checkinDate, LocalDate checkoutDate) {
		return checkinDate.isBefore(checkoutDate);
	}

	private GetAllHotelDTO toDTO (Hotel hotel) {
		GetAllHotelDTO hotelDTO = new GetAllHotelDTO();
		hotelDTO.setId(hotel.getId());
		hotelDTO.setAddress(hotel.getAddress());
		hotelDTO.setHotelName(hotel.getHotelName());
		hotelDTO.setCity(hotel.getCity());
		hotelDTO.setHotelPhoneNum(hotel.getHotelPhoneNum());
		hotelDTO.setHotelStars(hotel.getHotelStars());
		hotelDTO.setHotelDescription(hotel.getHotelDescription());
		hotelDTO.setCheckInTime(hotel.getCheckInTime());
		hotelDTO.setCheckOutTime(hotel.getCheckOutTime());
		hotelDTO.setStatus(hotel.getStatus());
		hotelDTO.setAccommodationType(hotel.getAccommodationType());
		hotelDTO.setHotelFacilities(hotel.getHotelFacilities());
		hotelDTO.setUser(hotel.getUser());
		hotelDTO.setHotelImages(
				hotel.getHotelImages().stream().map(this :: convertToImageDTO).collect(Collectors.toList()));
		hotelDTO.setRooms(hotel.getRooms());
		hotel.setListRating(hotel.getListRating());
		return hotelDTO;
	}

	private void updateHotelFacilities (Hotel hotel, List<HotelFacilityDTO> facilityDTOs) {
		List<HotelFacility> existingFacilities = hotelFacilityRepository.findByHotel(hotel);
		hotelFacilityRepository.deleteAll(existingFacilities);

		if (facilityDTOs != null)
		{
			for (HotelFacilityDTO facilityDTO : facilityDTOs)
			{
				Facility facility = facilityRepository.findById(facilityDTO.getFacilityId()).orElseThrow(
						() -> new RuntimeException("Facility not found with id: " + facilityDTO.getFacilityId()));
				HotelFacility hotelFacility = new HotelFacility();
				hotelFacility.setHotel(hotel);
				hotelFacility.setFacility(facility);
				hotelFacilityRepository.save(hotelFacility);
			}
		}
	}

	private Room mapToRoomEntity (RoomDTO roomDTO, Hotel hotel, RoomType roomType) {
		Room room = new Room();
		room.setCapacity(roomDTO.getCapacity());
		room.setPrice(roomDTO.getPrice());
		room.setQuantity(roomDTO.getQuantity());
		room.setRoomSize(roomDTO.getRoomSize());
		room.setDescription(roomDTO.getDescription());
		room.setServeBreakfast(roomDTO.isServeBreakfast());
		room.setHotel(hotel);
		room.setRoomType(roomType);
		return room;
	}

	private Hotel mapToHotelEntity (HotelDTO hotelDTO) {
		Hotel hotel = new Hotel();
		hotel.setAddress(hotelDTO.getAddress());
		hotel.setHotelName(hotelDTO.getHotelName());
		hotel.setCity(hotelDTO.getCity());
		hotel.setHotelPhoneNum(hotelDTO.getHotelPhoneNum());
		hotel.setHotelStars(hotelDTO.getHotelStars());
		hotel.setHotelDescription(hotelDTO.getHotelDescription());
		hotel.setStatus(hotelDTO.getStatus());
		hotel.setCheckInTime(hotelDTO.getCheckInTime());
		hotel.setCheckOutTime(hotelDTO.getCheckOutTime());
		hotel.setAccommodationType(new AccommodationType(hotelDTO.getAccommodationTypeId()));
		hotel.setUser(new User(hotelDTO.getUserId()));
		return hotel;
	}

	private HotelDTO mapToHotelDTO (Hotel hotel) {
		HotelDTO hotelDTO = new HotelDTO();
		hotelDTO.setAddress(hotel.getAddress());
		hotelDTO.setHotelName(hotel.getHotelName());
		hotelDTO.setCity(hotel.getCity());
		hotelDTO.setHotelPhoneNum(hotel.getHotelPhoneNum());
		hotelDTO.setHotelStars(hotel.getHotelStars());
		hotelDTO.setStatus(hotel.getStatus());
		hotelDTO.setHotelDescription(hotel.getHotelDescription());
		hotelDTO.setCheckInTime(hotel.getCheckInTime());
		hotelDTO.setCheckOutTime(hotel.getCheckOutTime());
		hotelDTO.setAccommodationTypeId(hotel.getAccommodationType().getId());
		hotelDTO.setUserId(hotel.getUser().getId());
		return hotelDTO;
	}

	private void updateHotelEntity (Hotel hotel, HotelDTO hotelDTO) {
		hotel.setAddress(hotelDTO.getAddress());
		hotel.setHotelName(hotelDTO.getHotelName());
		hotel.setCity(hotelDTO.getCity());
		hotel.setHotelPhoneNum(hotelDTO.getHotelPhoneNum());
		hotel.setHotelStars(hotelDTO.getHotelStars());
		hotel.setHotelDescription(hotelDTO.getHotelDescription());
		hotel.setCheckInTime(hotelDTO.getCheckInTime());
		hotel.setCheckOutTime(hotelDTO.getCheckOutTime());
		hotel.setAccommodationType(new AccommodationType(hotelDTO.getAccommodationTypeId()));
		hotel.setUser(new User(hotelDTO.getUserId()));
		hotel.setStatus(hotelDTO.getStatus());
	}

	private HotelImageDTO convertToImageDTO (HotelImage image) {
		HotelImageDTO dto = new HotelImageDTO();
		dto.setId(image.getId());
		dto.setImageName(image.getImageName());
		dto.setImageBase64(Base64.getEncoder().encodeToString(image.getImageBase64()));
		dto.setImageType(image.getImageType());
		dto.setImageUrl("/api/hotel-images/" + image.getId()); // Set URL
		return dto;
	}
}
