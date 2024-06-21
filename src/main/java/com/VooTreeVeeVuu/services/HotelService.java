package com.VooTreeVeeVuu.services;

import com.VooTreeVeeVuu.dto.*;
import com.VooTreeVeeVuu.domain.entity.*;
import com.VooTreeVeeVuu.domain.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
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
		updateRooms(updatedHotel, hotelDTO.getRooms());

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

	public List<GetAllHotelDTO> searchHotels (String searchTerm, Integer capacity, LocalDate checkIn,
	                                          LocalDate checkOut, Integer quantity) {
		List<Hotel> results = hotelRepository.searchHotels(searchTerm, capacity, checkIn, checkOut, quantity);
		return results.stream().map(this :: toDTO).collect(Collectors.toList());
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
		hotelDTO.setHotelImages(hotel.getHotelImages());
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

	private void updateRooms (Hotel hotel, List<RoomDTO> roomDTOs) {
		List<Room> existingRooms = roomRepository.findByHotel(hotel);
		roomRepository.deleteAll(existingRooms);

		if (roomDTOs != null)
		{
			for (RoomDTO roomDTO : roomDTOs)
			{
				RoomType roomType = roomTypeRepository.findById(roomDTO.getRoomTypeId()).orElseThrow(
						() -> new RuntimeException("RoomType not found with id: " + roomDTO.getRoomTypeId()));
				Room room = mapToRoomEntity(roomDTO, hotel, roomType);
				Room savedRoom = roomRepository.save(room);

				if (roomDTO.getRoomFacilities() != null)
				{
					List<RoomFacility> roomFacilities = new ArrayList<>();
					for (RoomFacilityDTO roomFacilityDTO : roomDTO.getRoomFacilities())
					{
						Facility facility = facilityRepository.findById(roomFacilityDTO.getFacilityId()).orElseThrow(
								() -> new RuntimeException(
										"Facility not found with id: " + roomFacilityDTO.getFacilityId()));
						RoomFacility roomFacility = new RoomFacility();
						roomFacility.setRoom(savedRoom);
						roomFacility.setFacility(facility);
						roomFacilities.add(roomFacility);
					}
					savedRoom.setRoomFacilities(roomFacilities);
					roomRepository.save(savedRoom);
				}
			}
		}
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
	}
}
