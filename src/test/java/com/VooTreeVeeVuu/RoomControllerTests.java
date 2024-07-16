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
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(roomController).build();
    }

    @Test
    @DisplayName("Test GET /rooms - Success")
    public void testGetAllRoomSuccess() throws Exception {
        // Mock data
        GetAllRoomDTO room1 = createSampleRoomDTO(); // Assume you have a method to create a sample GetAllRoomDTO
        List<GetAllRoomDTO> roomList = Arrays.asList(room1);

        // Mock use case method
        when(getAllRoomUseCase.getAllRoom()).thenReturn(roomList);

        // Perform GET request
        mockMvc.perform(MockMvcRequestBuilders.get("/api/rooms")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].capacity").value(2))
                .andExpect(jsonPath("$[0].price").value(100.0))
                .andExpect(jsonPath("$[0].quantity").value(10))
                .andExpect(jsonPath("$[0].roomSize").value(25.0))
                .andExpect(jsonPath("$[0].roomType.typeName").value("DELUX"))
                .andExpect(jsonPath("$[0].serveBreakfast").value(true))
                .andExpect(jsonPath("$[0].hotel.id").value(1))
                .andExpect(jsonPath("$[0].hotel.hotelName").value("Hotel Luxury"))
                .andExpect(jsonPath("$[0].listBooking[0].user.firstName").value("John"))
                .andExpect(jsonPath("$[0].listBooking[0].status").value("PENDING"));
    }


    @Test
    @DisplayName("Test GET /rooms/{id} - Success")
    public void testGetRoomByIdSuccess() throws Exception {
        // Mock data
        Long roomId = 1L;
        GetAllRoomDTO roomDTO = createSampleRoomDTO(); // Assume you have a method to create a sample GetAllRoomDTO

        // Mock use case method
        when(getRoomUseCase.getRoomById(roomId)).thenReturn(roomDTO);

        // Perform GET request
        mockMvc.perform(MockMvcRequestBuilders.get("/api/rooms/{id}", roomId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.capacity").value(2))
                .andExpect(jsonPath("$.price").value(100.0))
                .andExpect(jsonPath("$.quantity").value(10))
                .andExpect(jsonPath("$.roomSize").value(25.0))
                .andExpect(jsonPath("$.roomType.typeName").value("DELUX"))
                .andExpect(jsonPath("$.serveBreakfast").value(true))
                .andExpect(jsonPath("$.hotel.id").value(1))
                .andExpect(jsonPath("$.hotel.hotelName").value("Hotel Luxury"))
                .andExpect(jsonPath("$.listBooking[0].user.firstName").value("John"))
                .andExpect(jsonPath("$.listBooking[0].status").value("PENDING"));
    }


    @Test
    @DisplayName("Test POST /partner/create/{hotelId} - Success")
    public void testCreateRoomSuccess() throws Exception {
        // Mock data
        Long hotelId = 1L;
        RoomDTO roomDTO = createSampleRoomDTOs(); // Assume you have a method to create a sample RoomDTO

        // Mock use case method
        when(createRoom.createRoom(hotelId, roomDTO)).thenReturn(roomDTO);

        // Perform POST request
        mockMvc.perform(MockMvcRequestBuilders.post("/api/rooms/partner/create/{hotelId}", hotelId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(roomDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(roomDTO.getId()))
                .andExpect(jsonPath("$.capacity").value(roomDTO.getCapacity()))
                .andExpect(jsonPath("$.price").value(roomDTO.getPrice()))
                .andExpect(jsonPath("$.quantity").value(roomDTO.getQuantity()))
                .andExpect(jsonPath("$.roomSize").value(roomDTO.getRoomSize()))
                .andExpect(jsonPath("$.roomTypeId").value(roomDTO.getRoomTypeId()))
                .andExpect(jsonPath("$.serveBreakfast").value(roomDTO.isServeBreakfast()))
                .andExpect(jsonPath("$.hotelId").value(roomDTO.getHotelId()));
    }


    @Test
    @DisplayName("Test PUT /partner/update/{id} - Success")
    public void testUpdateRoomSuccess() throws Exception {
        // Mock data
        Long roomId = 1L;
        RoomDTO roomDTO = createSampleRoomDTOs(); // Assume you have a method to create a sample RoomDTO

        // Mock use case method
        when(roomService.updateRooms(roomId, roomDTO)).thenReturn(roomDTO);

        // Perform PUT request
        mockMvc.perform(MockMvcRequestBuilders.put("/api/rooms/partner/update/{id}", roomId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(roomDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(roomDTO.getId()))
                .andExpect(jsonPath("$.capacity").value(roomDTO.getCapacity()))
                .andExpect(jsonPath("$.price").value(roomDTO.getPrice()))
                .andExpect(jsonPath("$.quantity").value(roomDTO.getQuantity()))
                .andExpect(jsonPath("$.roomSize").value(roomDTO.getRoomSize()))
                .andExpect(jsonPath("$.roomTypeId").value(roomDTO.getRoomTypeId()))
                .andExpect(jsonPath("$.serveBreakfast").value(roomDTO.isServeBreakfast()))
                .andExpect(jsonPath("$.hotelId").value(roomDTO.getHotelId()));
    }

    @Test
    @DisplayName("Test DELETE /partner/delete/{id} - Success")
    public void testDeleteRoomSuccess() throws Exception {
        // Mock data
        Long roomId = 1L;

        // Mock use case method
        doNothing().when(deleteRoomUseCase).deleteRoom(roomId);

        // Perform DELETE request
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/partner/delete/{id}", roomId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

        // Verify that deleteRoomUseCase.deleteRoom() is called once
        verify(deleteRoomUseCase).deleteRoom(roomId);
    }



    @Test
    @DisplayName("Test POST /partner/{roomId}/images - Success")
    public void testUploadImagesSuccess() throws Exception {
        // Mock data
        Long roomId = 1L;
        MockMultipartFile file = new MockMultipartFile("files", "test.jpg", MediaType.IMAGE_JPEG_VALUE, "test".getBytes());

        // Mock service method
        GetAllRoomDTO updatedRoom = createSampleGetAllRoomDTO(); // Assume you have a method to create a sample GetAllRoomDTO
        when(roomService.saveRoomImages(roomId, Collections.singletonList(file))).thenReturn(updatedRoom);

        // Perform POST request
        mockMvc.perform(MockMvcRequestBuilders.multipart("/api/partner/{roomId}/images", roomId)
                        .file(file))
                .andExpect(MockMvcResultMatchers.status().isOk());

        // You can add more assertions here to verify the returned ResponseEntity content
    }

    private GetAllRoomDTO createSampleGetAllRoomDTO() {
        GetAllRoomDTO roomDTO = new GetAllRoomDTO();
        // Populate with sample data
        return roomDTO;
    }

    private RoomDTO createSampleRoomDTOs() {
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

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }





    private GetAllRoomDTO createSampleRoomDTO() {
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
        roomDTO.setHotel(hotel);

        Booking booking = new Booking();
        booking.setId(1L);
        booking.setCheckInDate(LocalDate.of(2024,06,21));
        booking.setCheckOutDate(LocalDate.of(2024,06,22));
        User user = new User();
        user.setFirstName("John");
        booking.setUser(user);
        booking.setStatus(Booking_status.PENDING);
        roomDTO.setListBooking(Arrays.asList(booking));

        return roomDTO;
    }
}
