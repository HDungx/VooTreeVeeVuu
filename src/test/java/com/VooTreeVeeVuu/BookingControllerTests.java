package com.VooTreeVeeVuu;

import com.VooTreeVeeVuu.controller.BookingController;
import com.VooTreeVeeVuu.domain.utils.Booking_status;
import com.VooTreeVeeVuu.dto.BookingDTO;
import com.VooTreeVeeVuu.dto.InsertBookingDTO;
import com.VooTreeVeeVuu.services.BookingService;
import com.VooTreeVeeVuu.usecase.BookingUsecase.GetAllBooking.GetAllBookingImpl;
import com.VooTreeVeeVuu.usecase.BookingUsecase.GetBooking.GetBookingImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Optional;
import java.util.regex.Matcher;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class BookingControllerTests {

	@Mock
	private MockMvc mockMvc;

	@InjectMocks
	private BookingController bookingController;
	@Mock
	private GetAllBookingImpl getAllBookingUseCase;
	@Mock
	private GetBookingImpl getBookingUseCase;

	@Mock
	private BookingService bookingService;
	private static final String END_POINT_PATH = "/api/bookings";

	@BeforeEach
	public void setUp () {
		MockitoAnnotations.openMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(bookingController).build();
	}


	@Test
	public void getAllBookingTest () throws Exception {
		// Arrange
		BookingDTO booking = new BookingDTO(1L, LocalDate.of(2024, 6, 21), LocalDate.of(2024, 6, 22), 200.0, "john_doe",
				"Hotel Luxury", "DELUX", "123 Main St", "A", 1L, 1L, Booking_status.PENDING, 1, 2,
				LocalDate.of(2024, 6, 20));
		when(getAllBookingUseCase.getAllBooking()).thenReturn(Arrays.asList(booking));

		// Act & Assert
		mockMvc.perform(MockMvcRequestBuilders.get(END_POINT_PATH).contentType(MediaType.APPLICATION_JSON)).andExpect(
				status().isOk()).andExpect(jsonPath("$[0].id").value(1L)).andExpect(
				jsonPath("$[0].checkInDate").value(Matchers.contains(2024, 6, 21))).andExpect(
				jsonPath("$[0].checkOutDate").value(Matchers.contains(2024, 6, 22))).andExpect(
				jsonPath("$[0].totalPrice").value(200.0)).andExpect(
				jsonPath("$[0].userName").value("john_doe")).andExpect(
				jsonPath("$[0].hotelName").value("Hotel Luxury")).andExpect(
				jsonPath("$[0].roomType").value("DELUX")).andExpect(
				jsonPath("$[0].address").value("123 Main St")).andExpect(jsonPath("$[0].city").value("A")).andExpect(
				jsonPath("$[0].hotelOwnerId").value(1L)).andExpect(jsonPath("$[0].status").value("PENDING")).andExpect(
				jsonPath("$[0].numOfRoom").value(1)).andExpect(jsonPath("$[0].numOfGuest").value(2)).andExpect(
				jsonPath("$[0].bookingDate").value(Matchers.contains(2024, 6, 20))).andDo(print());
	}


	@Test
	public void getBookingByIdTest () throws Exception {
		// Arrange
		BookingDTO booking = new BookingDTO(1L, LocalDate.of(2024, 6, 21), LocalDate.of(2024, 6, 22), 200.0, "john_doe",
				"Hotel Luxury", "DELUX", "123 Main St", "A", 1L, 1L, Booking_status.PENDING, 1, 2,
				LocalDate.of(2024, 6, 20));

		when(getBookingUseCase.getBookingById(1L)).thenReturn(Optional.of(booking));

		// Act & Assert
		mockMvc.perform(MockMvcRequestBuilders.get(END_POINT_PATH + "/1").contentType(MediaType.APPLICATION_JSON)).andExpect(
				status().isOk()).andExpect(jsonPath("$.id").value(1L)).andExpect(
				jsonPath("$.checkInDate").value(Matchers.contains(2024, 6, 21))).andExpect(
				jsonPath("$.checkOutDate").value(Matchers.contains(2024, 6, 22))).andExpect(
				jsonPath("$.totalPrice").value(200.0)).andExpect(
				jsonPath("$.userName").value("john_doe")).andExpect(
				jsonPath("$.hotelName").value("Hotel Luxury")).andExpect(
				jsonPath("$.roomType").value("DELUX")).andExpect(
				jsonPath("$.address").value("123 Main St")).andExpect(jsonPath("$.city").value("A")).andExpect(
				jsonPath("$.hotelOwnerId").value(1L)).andExpect(jsonPath("$.status").value("PENDING")).andExpect(
				jsonPath("$.numOfRoom").value(1)).andExpect(jsonPath("$.numOfGuest").value(2)).andExpect(
				jsonPath("$.bookingDate").value(Matchers.contains(2024, 6, 20))).andDo(print());
	}


	@Test
	public void getUserBookingHistoryTest () throws Exception {
		// Arrange
		BookingDTO booking = new BookingDTO(1L, LocalDate.of(2024, 6, 21), LocalDate.of(2024, 6, 22), 200.0, "john_doe",
				"Hotel Luxury", "DELUX", "123 Main St", "A", 1L, 1L, Booking_status.PENDING, 1, 2,
				LocalDate.of(2024, 6, 20));

		when(bookingService.getUserBookingHistory(1L)).thenReturn(Arrays.asList(booking));

		// Act & Assert
		mockMvc.perform(MockMvcRequestBuilders.get(END_POINT_PATH + "/1/booking-history").contentType(MediaType.APPLICATION_JSON)).andExpect(
				status().isOk()).andExpect(jsonPath("$[0].id").value(1L)).andExpect(
				jsonPath("$[0].checkInDate").value(Matchers.contains(2024, 6, 21))).andExpect(
				jsonPath("$[0].checkOutDate").value(Matchers.contains(2024, 6, 22))).andExpect(
				jsonPath("$[0].totalPrice").value(200.0)).andExpect(
				jsonPath("$[0].userName").value("john_doe")).andExpect(
				jsonPath("$[0].hotelName").value("Hotel Luxury")).andExpect(
				jsonPath("$[0].roomType").value("DELUX")).andExpect(
				jsonPath("$[0].address").value("123 Main St")).andExpect(jsonPath("$[0].city").value("A")).andExpect(
				jsonPath("$[0].hotelOwnerId").value(1L)).andExpect(jsonPath("$[0].status").value("PENDING")).andExpect(
				jsonPath("$[0].numOfRoom").value(1)).andExpect(jsonPath("$[0].numOfGuest").value(2)).andExpect(
				jsonPath("$[0].bookingDate").value(Matchers.contains(2024, 6, 20))).andDo(print());
	}

	@Test
	public void testCreateBooking_Success() throws Exception {
		// Arrange
		InsertBookingDTO insertBookingDTO = new InsertBookingDTO();
		insertBookingDTO.setId(1L);
		insertBookingDTO.setCheck_in_date(LocalDate.of(2024, 8, 1));
		insertBookingDTO.setCheck_out_date(LocalDate.of(2024, 8, 7));
		insertBookingDTO.setBookingDate(LocalDate.of(2024, 8, 1));
		insertBookingDTO.setNum_of_guest(2);
		insertBookingDTO.setNum_of_rooms(1);
		insertBookingDTO.setStatus(Booking_status.PENDING);
		insertBookingDTO.setTotal_price(100.0);
		insertBookingDTO.setRoomId(101L);
		insertBookingDTO.setUserId(1001L);

		InsertBookingDTO createdBookingDTO = new InsertBookingDTO();
		createdBookingDTO.setId(1L);
		createdBookingDTO.setCheck_in_date(LocalDate.of(2024, 8, 1));
		createdBookingDTO.setCheck_out_date(LocalDate.of(2024, 8, 7));
		createdBookingDTO.setBookingDate(LocalDate.of(2024, 8, 1));
		createdBookingDTO.setNum_of_guest(2);
		createdBookingDTO.setNum_of_rooms(1);
		createdBookingDTO.setStatus(Booking_status.PENDING);
		createdBookingDTO.setTotal_price(100.0);
		createdBookingDTO.setRoomId(101L);
		createdBookingDTO.setUserId(1001L);

		when(bookingService.createBooking(any(InsertBookingDTO.class))).thenReturn(createdBookingDTO);

		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.registerModule(new JavaTimeModule());

		// Act & Assert
		mockMvc.perform(MockMvcRequestBuilders.post("/api/bookings")  // Adjust the URL as needed
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(insertBookingDTO)))
				.andExpect(status().isCreated())
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(createdBookingDTO)));
	}
}
