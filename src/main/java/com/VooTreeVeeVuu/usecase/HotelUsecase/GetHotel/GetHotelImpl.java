package com.VooTreeVeeVuu.usecase.HotelUsecase.GetHotel;

import com.VooTreeVeeVuu.domain.entity.HotelImage;
import com.VooTreeVeeVuu.dto.GetAllHotelDTO;
import com.VooTreeVeeVuu.domain.entity.Hotel;
import com.VooTreeVeeVuu.domain.repository.HotelRepository;
import com.VooTreeVeeVuu.dto.HotelImageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GetHotelImpl implements GetHotel {
	@Autowired
	private HotelRepository hotelRepository;

	public GetAllHotelDTO getHotelById (Long id) {
		return hotelRepository.findById(id).map(this :: toDTO).orElseThrow(
				() -> new RuntimeException("Hotel not found"));
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

	private HotelImageDTO convertToImageDTO(HotelImage image) {
		HotelImageDTO dto = new HotelImageDTO();
		dto.setId(image.getId());
		dto.setImageName(image.getImageName());
		dto.setImageType(image.getImageType());
		dto.setImageUrl("/api/hotel-images/" + image.getId()); // Set URL
		return dto;
	}
}
