package com.VooTreeVeeVuu;

import com.VooTreeVeeVuu.controller.RatingController;
import com.VooTreeVeeVuu.domain.entity.*;
import com.VooTreeVeeVuu.domain.utils.Fac_Type;
import com.VooTreeVeeVuu.domain.utils.Gender;
import com.VooTreeVeeVuu.domain.utils.Hotel_status;
import com.VooTreeVeeVuu.dto.CreateRatingDTO;
import com.VooTreeVeeVuu.dto.RatingDTO;
import com.VooTreeVeeVuu.usecase.RatingUsecase.CreateRating.CreateRating;
import com.VooTreeVeeVuu.usecase.RatingUsecase.GetAllRating.GetAllRating;
import com.VooTreeVeeVuu.usecase.RatingUsecase.GetRatingForHotel.GetRatingForHotel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class RatingControllerTests {

	@Mock
	private MockMvc mockMvc;

	@InjectMocks
	private RatingController ratingController;

	@Mock
	private CreateRating createRatingUseCase;

	@Mock
	private GetAllRating getAllRatingUseCase;

	@Mock
	private GetRatingForHotel getRatingsForHotel;


	private static final String END_POINT_PATH = "/api/ratings";

	@BeforeEach
	public void setUp () {
		MockitoAnnotations.openMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(ratingController).build();
	}


	@Test
	public void getAllRatingTest () throws Exception {
		// Arrange
		User user = new User(1L, "John", "Doe", Gender.MALE, LocalDate.of(1990, 1, 1));
		HotelImage hotelImage = new HotelImage(1L, null, null, null);
		Facility facility = new Facility(2L, Fac_Type.ROOM, "Air Conditioning", "icon2.png");
		RoomFacility roomFacility = new RoomFacility(1L, facility);
		RoomImage roomImage = new RoomImage(1L, null, null, null);
		RoomType roomType = new RoomType(1l, "DELUX");
		Room room = new Room(1L, 2, 100.0, 10, 25.0, true, roomType, Arrays.asList(roomFacility), null,
				Arrays.asList(roomImage));
		facility = new Facility(1L, Fac_Type.HOTEL, "WiFi", "icon1.png");
		HotelFacility hotelFacility = new HotelFacility(1L, facility);
		Rating rating = new Rating(1L, 9, "Excellent service!", LocalDate.of(2024, 06, 20), user);
		AccommodationType accommodationType = new AccommodationType(1L, "Hotel");
		Hotel hotel = new Hotel(1L, "123 Main St", "Hotel Luxury", "Hanoi", "0123456789", 5, "A luxury hotel",
				Hotel_status.ACTIVE, LocalTime.of(14, 00, 00), LocalTime.of(12, 00, 00), accommodationType);

		RatingDTO ratingDTO = new RatingDTO(1L, 9, "Excellent service!", null, user, hotel);
		List<RatingDTO> ratings = Arrays.asList(ratingDTO);

		when(getAllRatingUseCase.getAllRatings()).thenReturn(ratings);

		// Act & Assert
		mockMvc.perform(MockMvcRequestBuilders.get(END_POINT_PATH).contentType(MediaType.APPLICATION_JSON)).andExpect(
						status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1L)).andExpect(
						MockMvcResultMatchers.jsonPath("$[0].rate").value(9)).andExpect(
						MockMvcResultMatchers.jsonPath("$[0].comment").value("Excellent service!"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[0].date").value("2024-06-20"))
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].user.id").value(1L)).andExpect(
						MockMvcResultMatchers.jsonPath("$[0].user.firstName").value("John")).andExpect(
						MockMvcResultMatchers.jsonPath("$[0].user.lastName").value("Doe")).andExpect(
						MockMvcResultMatchers.jsonPath("$[0].user.gender").value("MALE"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[0].user.dob").value("1990-01-01"))
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].hotel.id").value(1L)).andExpect(
						MockMvcResultMatchers.jsonPath("$[0].hotel.address").value("123 Main St")).andExpect(
						MockMvcResultMatchers.jsonPath("$[0].hotel.hotelName").value("Hotel Luxury")).andExpect(
						MockMvcResultMatchers.jsonPath("$[0].hotel.city").value("Hanoi")).andExpect(
						MockMvcResultMatchers.jsonPath("$[0].hotel.hotelPhoneNum").value("0123456789")).andExpect(
						MockMvcResultMatchers.jsonPath("$[0].hotel.hotelStars").value(5)).andExpect(
						MockMvcResultMatchers.jsonPath("$[0].hotel.hotelDescription").value("A luxury hotel")).andExpect(
						MockMvcResultMatchers.jsonPath("$[0].hotel.status").value("ACTIVE"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[0].hotel.checkInTime").value("14:00:00"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[0].hotel.checkOutTime").value("12:00:00"))
				.andDo(print());
	}

	@Test
	public void testCreateRating_Success () throws Exception {
		// Arrange
		CreateRatingDTO createRatingDTO = new CreateRatingDTO();
		createRatingDTO.setUserId(1L);
		createRatingDTO.setHotelId(1L);
		createRatingDTO.setRate(5);
		createRatingDTO.setComment("Excellent service!");

		RatingDTO ratingDTO = new RatingDTO();
		ratingDTO.setId(1L);
		ratingDTO.setUser(new User());
		ratingDTO.setHotel(new Hotel());
		ratingDTO.setRate(5);
		ratingDTO.setComment("Excellent service!");

		when(createRatingUseCase.createRating(any(CreateRatingDTO.class))).thenReturn(ratingDTO);

		ObjectMapper objectMapper = new ObjectMapper();

		// Act & Assert
		mockMvc.perform(post("/api/ratings") // Replace with your actual endpoint
				.contentType(MediaType.APPLICATION_JSON).content(
						objectMapper.writeValueAsString(createRatingDTO))).andExpect(status().isOk()).andExpect(
				content().contentType(MediaType.APPLICATION_JSON)).andExpect(
				content().json(objectMapper.writeValueAsString(ratingDTO)));
	}

	@Test
	public void getRatingsForHotelTest () throws Exception {
		User user = new User(1L, "John", "Doe", Gender.MALE, LocalDate.of(1990, 1, 1));
		HotelImage hotelImage = new HotelImage(1L, null, null, null);
		Facility facility = new Facility(2L, Fac_Type.ROOM, "Air Conditioning", "icon2.png");
		RoomFacility roomFacility = new RoomFacility(1L, facility);
		RoomImage roomImage = new RoomImage(1L, null, null, null);
		RoomType roomType = new RoomType(1L, "DELUX");
		Room room = new Room(1L, 2, 100.0, 10, 25.0, true, roomType, Arrays.asList(roomFacility), null,
				Arrays.asList(roomImage));
		facility = new Facility(1L, Fac_Type.HOTEL, "WiFi", "icon1.png");
		HotelFacility hotelFacility = new HotelFacility(1L, facility);
		Rating rating = new Rating(1L, 9, "Excellent service!", LocalDate.of(2024, 6, 20), user);
		AccommodationType accommodationType = new AccommodationType(1L, "Hotel");
		Hotel hotel = new Hotel(1L, "123 Main St", "Hotel Luxury", "Hanoi", "0123456789", 5, "A luxury hotel",
				Hotel_status.ACTIVE, LocalTime.of(14, 0), LocalTime.of(12, 0), accommodationType);

		RatingDTO rating1 = new RatingDTO(1L, 9, "Excellent service!", LocalDate.of(2024, 6, 20), user, hotel);
		RatingDTO rating2 = new RatingDTO(2L, 9, "String", LocalDate.of(2024, 7, 1), user, hotel);
		List<RatingDTO> ratings = Arrays.asList(rating1, rating2);

		when(getRatingsForHotel.getRatingsForHotel(1L)).thenReturn(ratings);

		// Act & Assert
		mockMvc.perform(MockMvcRequestBuilders.get(END_POINT_PATH + "/hotel/" + "1").contentType(
						MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andExpect(
						MockMvcResultMatchers.jsonPath("$[0].id").value(1L)).andExpect(
						MockMvcResultMatchers.jsonPath("$[0].rate").value(9)).andExpect(
						MockMvcResultMatchers.jsonPath("$[0].comment").value("Excellent service!")).andExpect(
						MockMvcResultMatchers.jsonPath("$[0].date").value(Matchers.contains(2024, 6, 20))).andExpect(
						MockMvcResultMatchers.jsonPath("$[0].user.id").value(1L)).andExpect(
						MockMvcResultMatchers.jsonPath("$[0].user.firstName").value("John")).andExpect(
						MockMvcResultMatchers.jsonPath("$[0].user.lastName").value("Doe")).andExpect(
						MockMvcResultMatchers.jsonPath("$[0].user.gender").value("MALE")).andExpect(
						MockMvcResultMatchers.jsonPath("$[0].user.dob").value(Matchers.contains(1990, 1, 1))).andExpect(
						MockMvcResultMatchers.jsonPath("$[0].hotel.id").value(1L)).andExpect(
						MockMvcResultMatchers.jsonPath("$[0].hotel.address").value("123 Main St")).andExpect(
						MockMvcResultMatchers.jsonPath("$[0].hotel.hotelName").value("Hotel Luxury")).andExpect(
						MockMvcResultMatchers.jsonPath("$[0].hotel.city").value("Hanoi")).andExpect(
						MockMvcResultMatchers.jsonPath("$[0].hotel.hotelPhoneNum").value("0123456789")).andExpect(
						MockMvcResultMatchers.jsonPath("$[0].hotel.hotelStars").value(5)).andExpect(
						MockMvcResultMatchers.jsonPath("$[0].hotel.hotelDescription").value("A luxury hotel")).andExpect(
						MockMvcResultMatchers.jsonPath("$[0].hotel.status").value("ACTIVE"))
//				.andExpect(MockMvcResultMatchers.jsonPath("$[0].hotel.checkInTime").value("14:00:00"))
//				.andExpect(MockMvcResultMatchers.jsonPath("$[0].hotel.checkOutTime").value("12:00:00"))
				.andExpect(MockMvcResultMatchers.jsonPath("$[1].id").value(2L)).andExpect(
						MockMvcResultMatchers.jsonPath("$[1].rate").value(9)).andExpect(
						MockMvcResultMatchers.jsonPath("$[1].comment").value("String")).andExpect(
						MockMvcResultMatchers.jsonPath("$[1].date").value(Matchers.contains(2024, 7, 1))).andDo(print());
	}

}