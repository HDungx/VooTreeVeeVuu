package com.VooTreeVeeVuu;

import com.VooTreeVeeVuu.controller.HotelController;
import com.VooTreeVeeVuu.domain.entity.*;
import com.VooTreeVeeVuu.domain.utils.Edit_status;
import com.VooTreeVeeVuu.domain.utils.Fac_Type;
import com.VooTreeVeeVuu.domain.utils.Gender;
import com.VooTreeVeeVuu.domain.utils.Hotel_status;
import com.VooTreeVeeVuu.dto.GetAllHotelDTO;
import com.VooTreeVeeVuu.dto.GetAllRoomDTO;
import com.VooTreeVeeVuu.dto.HotelImageDTO;
import com.VooTreeVeeVuu.services.HotelService;
import com.VooTreeVeeVuu.usecase.HotelUsecase.DeleteHotel.DeleteHotelImpl;
import com.VooTreeVeeVuu.usecase.HotelUsecase.GetAllHotel.GetAllHotelImpl;
import com.VooTreeVeeVuu.usecase.HotelUsecase.GetHotel.GetHotelImpl;
import com.VooTreeVeeVuu.usecase.HotelUsecase.ImagesUpload.ImagesUpload;
import com.VooTreeVeeVuu.usecase.HotelUsecase.UpdateStatusHotel.UpdateStatusHotelImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class HotelControllerTests {
    @Mock
    private MockMvc mockMvc;

    @InjectMocks
    private HotelController hotelController;

    @Mock
    private GetAllHotelImpl getAllHotelUseCase;

    @Mock
    private GetHotelImpl getHotelUseCase;

    @Mock
    private DeleteHotelImpl deleteHotelUseCase;

    @Mock
    private UpdateStatusHotelImpl updateStatusHotelUseCase;

    @Mock
    private ImagesUpload imagesUploadUseCase;

    @Mock
    private HotelService hotelService;

private static final String END_POINT_PATH="/api/hotels";
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(hotelController).build();
    }

	@Test
	public void testGetAllHotel() throws Exception {
		// Arrange
		GetAllHotelDTO hotel1 = new GetAllHotelDTO();
		hotel1.setId(1L);
		hotel1.setAddress("123 Main St");
		hotel1.setHotelName("Hotel One");
		hotel1.setCity("CityOne");
		hotel1.setHotelPhoneNum("1234567890");
		hotel1.setHotelStars(4);
		hotel1.setHotelDescription("Description One");
		hotel1.setStatus(Hotel_status.ACTIVE);  // Adjust based on your enum
		hotel1.setEdit_status(Edit_status.ACTIVE);  // Adjust based on your enum
		hotel1.setCheckInTime(LocalTime.of(14, 0));
		hotel1.setCheckOutTime(LocalTime.of(11, 0));
		hotel1.setAccommodationType(new AccommodationType());  // Adjust based on your enum
		hotel1.setUser(new User());  // Set appropriate properties
		hotel1.setHotelImages(Arrays.asList(new HotelImageDTO()));  // Set appropriate properties
		hotel1.setRooms(Arrays.asList(new GetAllRoomDTO()));  // Set appropriate properties
		hotel1.setHotelFacilities(Arrays.asList(new HotelFacility()));  // Set appropriate properties
		hotel1.setRatings(Arrays.asList(new Rating()));  // Set appropriate properties

		List<GetAllHotelDTO> hotels = Arrays.asList(hotel1);

		when(getAllHotelUseCase.getAllHotel()).thenReturn(hotels);

		ObjectMapper objectMapper = new ObjectMapper();

		// Act & Assert
		mockMvc.perform(MockMvcRequestBuilders.get("/api/hotels")
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(content().json(objectMapper.writeValueAsString(hotels)));
	}

    @Test
    public void testGetHotelById_Valid() throws Exception {
        // Create mock data
        Long hotelId = 1L;
        LocalDate checkinDate = LocalDate.of(2023, 7, 1);
        LocalDate checkoutDate = LocalDate.of(2023, 7, 10);
        int rooms = 2;
        int capacity = 4;

        GetAllHotelDTO hotel = new GetAllHotelDTO();
        hotel.setId(hotelId);
        hotel.setAddress("123 Main St");
        hotel.setHotelName("Hotel Luxury");
        hotel.setCity("Hanoi");
        hotel.setHotelPhoneNum("0123456789");
        hotel.setHotelStars(5);
        hotel.setHotelDescription("A luxury hotel");
        hotel.setStatus(Hotel_status.ACTIVE);
        hotel.setCheckInTime(LocalTime.of(14, 0));
        hotel.setCheckOutTime(LocalTime.of(12, 0));

        // Mock the behavior of the service
        given(hotelService.validateDates(checkinDate, checkoutDate)).willReturn(true);
        given(hotelService.getHotelByIdWithCriteria(hotelId, checkinDate, checkoutDate, rooms, capacity)).willReturn(hotel);

        // Perform the GET request and validate the response
        mockMvc.perform(get("/api/hotels/{id}", hotelId)
                        .param("checkinDate", checkinDate.toString())
                        .param("checkoutDate", checkoutDate.toString())
                        .param("rooms", String.valueOf(rooms))
                        .param("capacity", String.valueOf(capacity))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(hotelId))
                .andExpect(MockMvcResultMatchers.jsonPath("$.address").value("123 Main St"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.hotelName").value("Hotel Luxury"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.city").value("Hanoi"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.hotelPhoneNum").value("0123456789"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.hotelStars").value(5))
                .andExpect(MockMvcResultMatchers.jsonPath("$.hotelDescription").value("A luxury hotel"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value("ACTIVE"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.checkInTime").value("14:00:00"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.checkOutTime").value("12:00:00"))
                .andDo(print());
    }
    @Test
    public void testGetHotelById_InvalidDates() throws Exception {
        Long hotelId = 1L;
        LocalDate checkinDate = LocalDate.of(2023, 7, 1);
        LocalDate checkoutDate = LocalDate.of(2023, 6, 30);
        int rooms = 2;
        int capacity = 4;

        given(hotelService.validateDates(checkinDate, checkoutDate)).willReturn(false);

        mockMvc.perform(get("/api/hotels/{id}", hotelId)
                        .param("checkinDate", checkinDate.toString())
                        .param("checkoutDate", checkoutDate.toString())
                        .param("rooms", String.valueOf(rooms))
                        .param("capacity", String.valueOf(capacity))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().string(""))
                .andDo(print());
    }

	@Test
	public void testGetAllHotelByUser() throws Exception {
		// Arrange
		Long userId = 1L;
		GetAllHotelDTO hotel1 = new GetAllHotelDTO();
		hotel1.setId(1L);
		hotel1.setAddress("123 Main St");
		hotel1.setHotelName("Hotel One");
		hotel1.setCity("CityOne");
		hotel1.setHotelPhoneNum("1234567890");
		hotel1.setHotelStars(4);
		hotel1.setHotelDescription("Description One");
		hotel1.setStatus(Hotel_status.ACTIVE);  // Adjust based on your enum
		hotel1.setEdit_status(Edit_status.ACTIVE);  // Adjust based on your enum
		hotel1.setCheckInTime(LocalTime.of(14, 0));
		hotel1.setCheckOutTime(LocalTime.of(11, 0));
		hotel1.setAccommodationType(new AccommodationType());  // Adjust based on your enum
		hotel1.setUser(new User());  // Set appropriate properties
		hotel1.setHotelImages(Arrays.asList(new HotelImageDTO()));  // Set appropriate properties
		hotel1.setRooms(Arrays.asList(new GetAllRoomDTO()));  // Set appropriate properties
		hotel1.setHotelFacilities(Arrays.asList(new HotelFacility()));  // Set appropriate properties
		hotel1.setRatings(Arrays.asList(new Rating()));  // Set appropriate properties

		List<GetAllHotelDTO> hotels = Arrays.asList(hotel1);

		when(hotelService.getAllHotelByUser(anyLong())).thenReturn(hotels);

		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.registerModule(new JavaTimeModule());

		// Act & Assert
		mockMvc.perform(MockMvcRequestBuilders.get("/api/hotels/partner/getAllHotel/{userId}", userId)
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(content().json(objectMapper.writeValueAsString(hotels)));
	}



	@Test
	public void testSearchHotels() throws Exception {
		// Arrange
		LocalDate checkinDate = LocalDate.of(2024, 8, 10);
		LocalDate checkoutDate = LocalDate.of(2024, 8, 15);
		GetAllHotelDTO hotel1 = new GetAllHotelDTO();
		hotel1.setId(1L);
		hotel1.setAddress("123 Main St");
		hotel1.setHotelName("Hotel One");
		hotel1.setCity("CityOne");
		hotel1.setHotelPhoneNum("1234567890");
		hotel1.setHotelStars(4);
		hotel1.setHotelDescription("Description One");
		hotel1.setStatus(Hotel_status.ACTIVE);  // Adjust based on your enum
		hotel1.setEdit_status(Edit_status.ACTIVE);  // Adjust based on your enum
		hotel1.setCheckInTime(LocalTime.of(14, 0));
		hotel1.setCheckOutTime(LocalTime.of(11, 0));
		hotel1.setAccommodationType(new AccommodationType());  // Adjust based on your enum
		hotel1.setUser(new User());  // Set appropriate properties
		hotel1.setHotelImages(Arrays.asList(new HotelImageDTO()));  // Set appropriate properties
		hotel1.setRooms(Arrays.asList(new GetAllRoomDTO()));  // Set appropriate properties
		hotel1.setHotelFacilities(Arrays.asList(new HotelFacility()));  // Set appropriate properties
		hotel1.setRatings(Arrays.asList(new Rating()));  // Set appropriate properties

		List<GetAllHotelDTO> hotels = Arrays.asList(hotel1);

		when(hotelService.validateDates(any(LocalDate.class), any(LocalDate.class))).thenReturn(true);
		when(hotelService.searchHotels(anyString(), anyString(), any(LocalDate.class), any(LocalDate.class), anyInt(), anyInt())).thenReturn(hotels);

		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.registerModule(new JavaTimeModule());

		// Act & Assert
		mockMvc.perform(MockMvcRequestBuilders.get("/api/hotels/search")
						.param("hotelName", "Hotel One")
						.param("city", "CityOne")
						.param("checkinDate", "2024-08-10")
						.param("checkoutDate", "2024-08-15")
						.param("rooms", "1")
						.param("capacity", "2")
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(content().json(objectMapper.writeValueAsString(hotels)));
	}

	@Test
	public void testGetHotelById_Success() throws Exception {
		// Arrange
		Long hotelId = 1L;
		LocalDate checkinDate = LocalDate.of(2024, 8, 10);
		LocalDate checkoutDate = LocalDate.of(2024, 8, 15);
		int rooms = 1;
		int capacity = 2;

		GetAllHotelDTO hotel = new GetAllHotelDTO();
		hotel.setId(hotelId);
		hotel.setAddress("123 Main St");
		hotel.setHotelName("Hotel One");
		hotel.setCity("CityOne");
		hotel.setHotelPhoneNum("1234567890");
		hotel.setHotelStars(4);
		hotel.setHotelDescription("Description One");
		hotel.setStatus(Hotel_status.ACTIVE);  // Adjust based on your enum
		hotel.setEdit_status(Edit_status.ACTIVE);  // Adjust based on your enum
		hotel.setCheckInTime(LocalTime.of(14, 0));
		hotel.setCheckOutTime(LocalTime.of(11, 0));
		hotel.setAccommodationType(new AccommodationType());  // Adjust based on your enum
		hotel.setUser(new User());  // Set appropriate properties
		hotel.setHotelImages(Arrays.asList(new HotelImageDTO()));  // Set appropriate properties
		hotel.setRooms(Arrays.asList(new GetAllRoomDTO()));  // Set appropriate properties
		hotel.setHotelFacilities(Arrays.asList(new HotelFacility()));  // Set appropriate properties
		hotel.setRatings(Arrays.asList(new Rating()));  // Set appropriate properties

		when(hotelService.validateDates(any(LocalDate.class), any(LocalDate.class))).thenReturn(true);
		when(hotelService.getHotelByIdWithCriteria(anyLong(), any(LocalDate.class), any(LocalDate.class), anyInt(), anyInt())).thenReturn(hotel);

		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.registerModule(new JavaTimeModule());
		// Act & Assert
		mockMvc.perform(MockMvcRequestBuilders.get("/api/hotels/{id}", hotelId)
						.param("checkinDate", "2024-08-10")
						.param("checkoutDate", "2024-08-15")
						.param("rooms", "1")
						.param("capacity", "2")
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(content().json(objectMapper.writeValueAsString(hotel)));
	}

	@Test
	public void testUploadImages_Success() throws Exception {
		// Arrange
		Long hotelId = 1L;

		MockMultipartFile file1 = new MockMultipartFile("files", "image1.jpg", MediaType.IMAGE_JPEG_VALUE, "image1".getBytes());
		MockMultipartFile file2 = new MockMultipartFile("files", "image2.jpg", MediaType.IMAGE_JPEG_VALUE, "image2".getBytes());

		GetAllHotelDTO updatedHotel = new GetAllHotelDTO();
		updatedHotel.setId(hotelId);
		// set other properties of updatedHotel as needed

		when(hotelService.saveHotelImages(anyLong(), anyList())).thenReturn(updatedHotel);

		ObjectMapper objectMapper = new ObjectMapper();

		// Act & Assert
		mockMvc.perform(MockMvcRequestBuilders.multipart("/api/hotels/{hotelId}/images", hotelId)
						.file(file1)
						.file(file2))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(content().json(objectMapper.writeValueAsString(updatedHotel)));
	}

}