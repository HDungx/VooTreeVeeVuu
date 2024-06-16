package com.VooTreeVeeVuu.services;

import com.VooTreeVeeVuu.adapters.dto.HotelDTO;
import com.VooTreeVeeVuu.adapters.dto.HotelFacilityDTO;
import com.VooTreeVeeVuu.adapters.dto.HotelWithDetailsDTO;
import com.VooTreeVeeVuu.adapters.dto.RoomDTO;
import com.VooTreeVeeVuu.domain.entity.*;
import com.VooTreeVeeVuu.domain.repository.HotelFacilityRepository;
import com.VooTreeVeeVuu.domain.repository.HotelRepository;
import com.VooTreeVeeVuu.domain.repository.RoomRepository;
import com.VooTreeVeeVuu.usecase.HotelFacilityUsecase.CreateHotelFacilityUseCase;
import com.VooTreeVeeVuu.usecase.HotelUsecase.CreateHotelUseCase;
import com.VooTreeVeeVuu.usecase.RoomUsecase.CreateRoomUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class HotelService {
	@Autowired
	private HotelRepository hotelRepository;

	@Autowired
	private HotelFacilityRepository hotelFacilityRepository;

	@Autowired
	private RoomRepository roomRepository;

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
				Room room = mapToRoomEntity(roomDTO, savedHotel);
				roomRepository.save(room);
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

	private Room mapToRoomEntity (RoomDTO roomDTO, Hotel hotel) {
		Room room = new Room();
		room.setCapacity(roomDTO.getCapacity());
		room.setPrice(roomDTO.getPrice());
		room.setQuantity(roomDTO.getQuantity());
		room.setRoomSize(roomDTO.getRoomSize());
		room.setDescription(roomDTO.getDescription());
		room.setServeBreakfast(roomDTO.isServeBreakfast());
		room.setHotel(hotel);
		room.setRoomType(new RoomType(roomDTO.getRoomTypeId()));
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
}
