package com.VooTreeVeeVuu.services;

import com.VooTreeVeeVuu.adapters.dto.HotelDTO;
import com.VooTreeVeeVuu.adapters.dto.HotelFacilityDTO;
import com.VooTreeVeeVuu.adapters.dto.RoomDTO;
import com.VooTreeVeeVuu.adapters.dto.RoomFacilityDTO;
import com.VooTreeVeeVuu.domain.entity.*;
import com.VooTreeVeeVuu.domain.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
				RoomType roomType = roomTypeRepository.findById(roomDTO.getRoomTypeId())
						.orElseThrow(() -> new RuntimeException("RoomType not found with id: " + roomDTO.getRoomTypeId()));
				Room room = mapToRoomEntity(roomDTO, savedHotel, roomType);
				roomRepository.save(room);
				if (roomDTO.getRoomFacilities() != null) {
					for (RoomFacilityDTO roomFacilityDTO : roomDTO.getRoomFacilities()) {
						Facility facility = facilityRepository.findById(roomFacilityDTO.getFacilityId())
								.orElseThrow(() -> new RuntimeException("Facility not found with id: " + roomFacilityDTO.getFacilityId()));
						RoomFacility roomFacility = new RoomFacility();
						roomFacility.setRoom(room);
						roomFacility.setFacility(facility);
						//room.getRoomFacilities().add(roomFacility);
						roomFacilityRepository.save(roomFacility);
					}
					roomRepository.save(room);
				}
			}
		}

		return mapToHotelDTO(savedHotel);
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

	private Room mapToRoomEntity(RoomDTO roomDTO, Hotel hotel, RoomType roomType) {
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

//		hotelDTO.setHotelFacilities(hotel.getHotelFacilities().stream()
//				.map(hf -> new HotelFacilityDTO(hf.getFacility().getFacId()))
//				.collect(Collectors.toList()));

//		hotelDTO.setRooms(hotel.getRooms().stream()
//				.map(room -> {
//					RoomDTO roomDTO = new RoomDTO();
//					roomDTO.setCapacity(room.getCapacity());
//					roomDTO.setPrice(room.getPrice());
//					roomDTO.setQuantity(room.getQuantity());
//					roomDTO.setRoomSize(room.getRoomSize());
//					roomDTO.setDescription(room.getDescription());
//					roomDTO.setServeBreakfast(room.isServeBreakfast());
//					roomDTO.setRoomTypeId(room.getRoomType().getId());
//					roomDTO.setRoomFacilities(room.getRoomFacilities().stream()
//							.map(rf -> new RoomFacilityDTO(rf.getFacility().getFacId()))
//							.collect(Collectors.toList()));
//					return roomDTO;
//				})
//				.collect(Collectors.toList()));
		return hotelDTO;
	}
}
