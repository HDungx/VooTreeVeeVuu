package com.VooTreeVeeVuu;

import com.VooTreeVeeVuu.controller.RoomController;
import com.VooTreeVeeVuu.domain.entity.Booking;
import com.VooTreeVeeVuu.domain.entity.Hotel;
import com.VooTreeVeeVuu.domain.entity.RoomType;
import com.VooTreeVeeVuu.domain.entity.User;
import com.VooTreeVeeVuu.domain.utils.Booking_status;
import com.VooTreeVeeVuu.dto.GetAllRoomDTO;
import com.VooTreeVeeVuu.dto.RoomDTO;
import com.VooTreeVeeVuu.services.RoomService;
import com.VooTreeVeeVuu.usecase.RoomUsecase.CreateRoom.CreateRoom;
import com.VooTreeVeeVuu.usecase.RoomUsecase.DeleteRoom.DeleteRoomImpl;
import com.VooTreeVeeVuu.usecase.RoomUsecase.GetAllRoom.GetAllRoomImpl;
import com.VooTreeVeeVuu.usecase.RoomUsecase.GetRoom.GetRoomImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class RoomControllerTests {

	@Mock
	private MockMvc mockMvc;

	@InjectMocks
	private RoomController roomController;

	@Mock
	private DeleteRoomImpl deleteRoomUseCase;

	@Mock
	private GetAllRoomImpl getAllRoomUseCase;

	@Mock
	private GetRoomImpl getRoomUseCase;

	@Mock
	private RoomService roomService;

	@Mock
	private CreateRoom createRoom;


	@BeforeEach
	public void setUp () {
		MockitoAnnotations.openMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(roomController).build();
	}

	@Test
	public void testGetAllRoom () throws Exception {
		// Arrange
		GetAllRoomDTO room1 = new GetAllRoomDTO();
		room1.setId(1L);
		room1.setCapacity(2);
		room1.setPrice(100.0);
		room1.setQuantity(5);
		room1.setRoomSize(25.0);
		room1.setDescription("Room 1 description");
		room1.setServeBreakfast(true);
		room1.setHotelId(1L);
		room1.setHotelName("Hotel 1");
		room1.setOwnerEmail("owner1@example.com");
		room1.setAvailableRooms(3);

		GetAllRoomDTO room2 = new GetAllRoomDTO();
		room2.setId(2L);
		room2.setCapacity(3);
		room2.setPrice(150.0);
		room2.setQuantity(2);
		room2.setRoomSize(30.0);
		room2.setDescription("Room 2 description");
		room2.setServeBreakfast(false);
		room2.setHotelId(2L);
		room2.setHotelName("Hotel 2");
		room2.setOwnerEmail("owner2@example.com");
		room2.setAvailableRooms(1);

		List<GetAllRoomDTO> rooms = Arrays.asList(room1, room2);

		when(getAllRoomUseCase.getAllRoom()).thenReturn(rooms);

		// Act & Assert
		mockMvc.perform(get("/api/rooms")) // Adjust the endpoint as needed
				.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON)).andExpect(
						jsonPath("$[0].id").value(1)).andExpect(jsonPath("$[0].capacity").value(2)).andExpect(
						jsonPath("$[0].price").value(100.0)).andExpect(jsonPath("$[0].quantity").value(5)).andExpect(
						jsonPath("$[0].roomSize").value(25.0)).andExpect(
						jsonPath("$[0].description").value("Room 1 description")).andExpect(
						jsonPath("$[0].serveBreakfast").value(true)).andExpect(jsonPath("$[0].hotelId").value(1)).andExpect(
						jsonPath("$[0].hotelName").value("Hotel 1")).andExpect(
						jsonPath("$[0].ownerEmail").value("owner1@example.com")).andExpect(
						jsonPath("$[0].availableRooms").value(3)).andExpect(jsonPath("$[1].id").value(2)).andExpect(
						jsonPath("$[1].capacity").value(3)).andExpect(jsonPath("$[1].price").value(150.0)).andExpect(
						jsonPath("$[1].quantity").value(2)).andExpect(jsonPath("$[1].roomSize").value(30.0)).andExpect(
						jsonPath("$[1].description").value("Room 2 description")).andExpect(
						jsonPath("$[1].serveBreakfast").value(false)).andExpect(jsonPath("$[1].hotelId").value(2)).andExpect(
						jsonPath("$[1].hotelName").value("Hotel 2")).andExpect(
						jsonPath("$[1].ownerEmail").value("owner2@example.com")).andExpect(
						jsonPath("$[1].availableRooms").value(1)).andDo(print());
	}


	@Test
	public void testGetRoomById () throws Exception {
		// Arrange
		Long roomId = 1L;
		GetAllRoomDTO room = new GetAllRoomDTO();
		room.setId(roomId);
		room.setCapacity(2);
		room.setPrice(100.0);
		room.setQuantity(5);
		room.setRoomSize(25.0);
		room.setDescription("Room description");
		room.setServeBreakfast(true);
		room.setHotelId(1L);
		room.setHotelName("Hotel 1");
		room.setOwnerEmail("owner@example.com");
		room.setAvailableRooms(3);

		when(getRoomUseCase.getRoomById(roomId)).thenReturn(room);

		// Act & Assert
		mockMvc.perform(get("/api/rooms/{id}", roomId)) // Adjust the endpoint as needed
				.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON)).andExpect(
						jsonPath("$.id").value(roomId)).andExpect(jsonPath("$.capacity").value(2)).andExpect(
						jsonPath("$.price").value(100.0)).andExpect(jsonPath("$.quantity").value(5)).andExpect(
						jsonPath("$.roomSize").value(25.0)).andExpect(
						jsonPath("$.description").value("Room description")).andExpect(
						jsonPath("$.serveBreakfast").value(true)).andExpect(jsonPath("$.hotelId").value(1)).andExpect(
						jsonPath("$.hotelName").value("Hotel 1")).andExpect(
						jsonPath("$.ownerEmail").value("owner@example.com")).andExpect(jsonPath("$.availableRooms").value(3));
	}


	@Test
	public void testCreateRoom () throws Exception {
		// Arrange
		Long hotelId = 1L;
		RoomDTO roomDTO = new RoomDTO();
		roomDTO.setId(1L);
		roomDTO.setCapacity(2);
		roomDTO.setPrice(100.0);
		roomDTO.setQuantity(5);
		roomDTO.setRoomSize(25.0);
		roomDTO.setServeBreakfast(true);
		roomDTO.setHotelId(hotelId);

		Mockito.when(createRoom.createRoom(Mockito.anyLong(), Mockito.any(RoomDTO.class))).thenReturn(roomDTO);

		ObjectMapper objectMapper = new ObjectMapper();

		// Act & Assert
		mockMvc.perform(post("/api/rooms/partner/create/{hotelId}", hotelId) // Adjust the endpoint as needed
				.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(roomDTO))).andExpect(
				status().isCreated()).andExpect(content().contentType(MediaType.APPLICATION_JSON)).andExpect(
				jsonPath("$.id").value(1)).andExpect(jsonPath("$.capacity").value(2)).andExpect(
				jsonPath("$.price").value(100.0)).andExpect(jsonPath("$.quantity").value(5)).andExpect(
				jsonPath("$.roomSize").value(25.0)).andExpect(jsonPath("$.serveBreakfast").value(true)).andExpect(
				jsonPath("$.hotelId").value(hotelId));
	}


	@Test
	public void testUpdateRoom () throws Exception {
		// Arrange
		Long hotelId = 1L;
		Long roomId = 1L;
		RoomDTO roomDTO = new RoomDTO();
		roomDTO.setId(roomId);
		roomDTO.setCapacity(2);
		roomDTO.setPrice(100.0);
		roomDTO.setQuantity(5);
		roomDTO.setRoomSize(25.0);
		roomDTO.setServeBreakfast(false);
		roomDTO.setHotelId(hotelId);

		Mockito.when(roomService.updateRooms(Mockito.anyLong(), Mockito.any(RoomDTO.class))).thenReturn(roomDTO);
		ObjectMapper objectMapper = new ObjectMapper();

		// Act & Assert
		mockMvc.perform(put("/api/rooms/partner/update/{id}", roomId) // Adjust the endpoint as needed
				.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(roomDTO))).andExpect(
				status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON)).andExpect(
				jsonPath("$.id").value(roomId)).andExpect(jsonPath("$.capacity").value(2)).andExpect(
				jsonPath("$.price").value(100.0)).andExpect(jsonPath("$.quantity").value(5)).andExpect(
				jsonPath("$.roomSize").value(25.0)).andExpect(jsonPath("$.serveBreakfast").value(false)).andExpect(
				jsonPath("$.hotelId").value(1));
	}

	@Test
	@DisplayName ("Test DELETE /partner/delete/{id} - Success")
	public void testDeleteRoomSuccess () throws Exception {
		// Mock data
		Long roomId = 1L;

		// Mock use case method
		doNothing().when(deleteRoomUseCase).deleteRoom(roomId);

		// Perform DELETE request
		mockMvc.perform(MockMvcRequestBuilders.delete("/api/rooms/delete/{id}", roomId).contentType(
				MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk());

		// Verify that deleteRoomUseCase.deleteRoom() is called once
		verify(deleteRoomUseCase).deleteRoom(roomId);
	}


	@Test
	@DisplayName ("Test POST /partner/{roomId}/images - Success")
	public void testUploadImagesSuccess () throws Exception {
		// Mock data
		Long roomId = 1L;
		MockMultipartFile file = new MockMultipartFile("files", "test.jpg", MediaType.IMAGE_JPEG_VALUE,
				"test".getBytes());

		// Mock service method
		GetAllRoomDTO updatedRoom = createSampleGetAllRoomDTO(); // Assume you have a method to create a sample GetAllRoomDTO
		when(roomService.saveRoomImages(roomId, Collections.singletonList(file))).thenReturn(updatedRoom);

		// Perform POST request
		mockMvc.perform(MockMvcRequestBuilders.multipart("/api/rooms/{roomId}/images", roomId).file(file)).andExpect(
				MockMvcResultMatchers.status().isOk());

		// You can add more assertions here to verify the returned ResponseEntity content
	}

	private GetAllRoomDTO createSampleGetAllRoomDTO () {
		GetAllRoomDTO roomDTO = new GetAllRoomDTO();
		// Populate with sample data
		return roomDTO;
	}

	private RoomDTO createSampleRoomDTOs () {
		RoomDTO roomDTO = new RoomDTO();
		roomDTO.setId(1L);
		roomDTO.setCapacity(2);
		roomDTO.setPrice(100.0);
		roomDTO.setQuantity(10);
		roomDTO.setRoomSize(25.0);
		roomDTO.setRoomTypeId(1L);
		roomDTO.setServeBreakfast(true);
		roomDTO.setHotelId(1L);

		return roomDTO;
	}

	public static String asJsonString (final Object obj) {
		try
		{
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}


	private GetAllRoomDTO createSampleRoomDTO () {
		GetAllRoomDTO roomDTO = new GetAllRoomDTO();
		roomDTO.setId(1L);
		roomDTO.setCapacity(2);
		roomDTO.setPrice(100.0);
		roomDTO.setQuantity(10);
		roomDTO.setRoomSize(25.0);
		roomDTO.setDescription("A comfortable room");

		RoomType roomType = new RoomType();
		roomType.setId(1L);
		roomType.setTypeName("DELUX");
		roomDTO.setRoomType(roomType);

		roomDTO.setServeBreakfast(true);

		Hotel hotel = new Hotel();
		hotel.setId(1L);
		hotel.setHotelName("Hotel Luxury");
		//  roomDTO.setHotel(hotel);

		Booking booking = new Booking();
		booking.setId(1L);
		booking.setCheckInDate(LocalDate.of(2024, 06, 21));
		booking.setCheckOutDate(LocalDate.of(2024, 06, 22));
		User user = new User();
		user.setFirstName("John");
		booking.setUser(user);
		booking.setStatus(Booking_status.PENDING);
		roomDTO.setListBooking(Arrays.asList(booking));

		return roomDTO;
	}
}
