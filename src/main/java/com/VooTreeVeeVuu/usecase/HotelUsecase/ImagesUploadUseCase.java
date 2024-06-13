package com.VooTreeVeeVuu.usecase.HotelUsecase;

import com.VooTreeVeeVuu.adapters.dto.HotelDTO;
import com.VooTreeVeeVuu.adapters.dto.HotelImageDTO;
import com.VooTreeVeeVuu.domain.entity.Hotel;
import com.VooTreeVeeVuu.domain.entity.HotelImage;
import com.VooTreeVeeVuu.domain.repository.HotelImageRepository;
import com.VooTreeVeeVuu.domain.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ImagesUploadUseCase {
	@Autowired
	private HotelRepository hotelRepository;

	@Autowired
	private HotelImageRepository hotelImageRepository;

	public Optional<HotelDTO> uploadImg (Long hotelId, List<HotelImageDTO> imageDTO) {
		return hotelRepository.findById(hotelId).map(hotel -> {
			List<HotelImage> hotelImages = imageDTO.stream().map(dto -> {
				HotelImage hotelImage = new HotelImage();
				hotelImage.setPath(dto.getPath());
				hotelImage.setHotel(hotel);
				return hotelImage;
			}).toList();
			hotel.getHotelImages().addAll(hotelImages);
			return hotelRepository.save(hotel);
		}).map(this :: toDTO);
	}

	private HotelDTO toDTO (Hotel hotel) {
		HotelDTO dto = new HotelDTO();
		dto.setAddress(hotel.getAddress());
		dto.setHotelName(hotel.getHotelName());
		dto.setCity(hotel.getCity());
		dto.setHotelPhoneNum(hotel.getHotelPhoneNum());
		dto.setHotelStars(hotel.getHotelStars());
		dto.setHotelDescription(hotel.getHotelDescription());
		dto.setStatus(hotel.getStatus());
		dto.setCheckInTime(hotel.getCheckInTime());
		dto.setCheckOutTime(hotel.getCheckOutTime());
		dto.setUser(hotel.getUser());
		dto.setHotelImages(hotel.getHotelImages());
		dto.setHotelFacilities(hotel.getHotelFacilities());
		return dto;
	}

	public HotelImage toEntity (HotelImageDTO dto) {
		HotelImage hotelImage = new HotelImage();
		hotelImage.setId(dto.getId());
		hotelImage.setPath(dto.getPath());
		return hotelImage;
	}
}
