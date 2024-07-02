package com.VooTreeVeeVuu;

import com.VooTreeVeeVuu.controller.HotelController;
import com.VooTreeVeeVuu.domain.entity.*;
import com.VooTreeVeeVuu.domain.utils.Fac_Type;
import com.VooTreeVeeVuu.domain.utils.Gender;
import com.VooTreeVeeVuu.domain.utils.Hotel_status;
import com.VooTreeVeeVuu.dto.GetAllHotelDTO;
import com.VooTreeVeeVuu.services.HotelService;
import com.VooTreeVeeVuu.usecase.HotelUsecase.DeleteHotel.DeleteHotelImpl;
import com.VooTreeVeeVuu.usecase.HotelUsecase.GetAllHotel.GetAllHotelImpl;
import com.VooTreeVeeVuu.usecase.HotelUsecase.GetHotel.GetHotelImpl;
import com.VooTreeVeeVuu.usecase.HotelUsecase.ImagesUpload.ImagesUpload;
import com.VooTreeVeeVuu.usecase.HotelUsecase.UpdateStatusHotel.UpdateStatusHotelImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
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
        // Create mock data
        GetAllHotelDTO hotel1 = new GetAllHotelDTO();
        hotel1.setId(1L);
        hotel1.setAddress("123 Main St");
        hotel1.setHotelName("Hotel Luxury");
        hotel1.setCity("Hanoi");
        hotel1.setHotelPhoneNum("0123456789");
        hotel1.setHotelStars(5);
        hotel1.setHotelDescription("A luxury hotel");
        hotel1.setStatus(Hotel_status.ACTIVE);
//        hotel1.setCheckInTime("14:00:00");
//        hotel1.setCheckOutTime("12:00:00");

        AccommodationType accommodationType1 = new AccommodationType();
        accommodationType1.setId(1L);
        accommodationType1.setTypeName("Hotel");
        hotel1.setAccommodationType(accommodationType1);

        User user1 = new User();
        user1.setId(1L);
        user1.setFirstName("John");
        user1.setLastName("Doe");
        user1.setGender(Gender.MALE);
//        user1.setDob("1990-01-01");
        hotel1.setUser(user1);

        HotelImage hotelImage1 = new HotelImage();
        hotelImage1.setId(1L);
//        hotelImage1.setPath("hotel1.jpg");
//        hotel1.setHotelImages(Arrays.asList(hotelImage1));

        RoomType roomType1 = new RoomType();
        roomType1.setId(1L);
        roomType1.setTypeName("DELUX");

        Room room1 = new Room();
        room1.setId(1L);
        room1.setCapacity(2);
        room1.setPrice(100.0);
        room1.setQuantity(10);
        room1.setRoomSize(25.0);
        room1.setDescription("A comfortable room");
        room1.setServeBreakfast(true);
        room1.setRoomType(roomType1);

        RoomImage roomImage1 = new RoomImage();
        roomImage1.setId(1L);
//        roomImage1.setPath("room1.jpg");
        room1.setRoom_images(Arrays.asList(roomImage1));
        hotel1.setRooms(Arrays.asList(room1));

        HotelFacility hotelFacility1 = new HotelFacility();
        hotelFacility1.setId(1L);
        Facility facility1 = new Facility();
        facility1.setFacId(1L);
        facility1.setFacType(Fac_Type.HOTEL);
        facility1.setFacName("WiFi");
        facility1.setFacIcon("wifi.png");
        hotelFacility1.setFacility(facility1);
        hotel1.setHotelFacilities(Arrays.asList(hotelFacility1));

        GetAllHotelDTO hotel2 = new GetAllHotelDTO();
        hotel2.setId(2L);
        hotel2.setAddress("TP HCM");
        hotel2.setHotelName("Mường Thanh");
        hotel2.setCity("Hồ Chí Minh");
        hotel2.setHotelPhoneNum("346135365");
        hotel2.setHotelStars(5);
        hotel2.setHotelDescription("aaaa");
        hotel2.setStatus(Hotel_status.PENDING);
//        hotel2.setCheckInTime("04:45:00");
//        hotel2.setCheckOutTime("01:45:00");

        AccommodationType accommodationType2 = new AccommodationType();
        accommodationType2.setId(1L);
        accommodationType2.setTypeName("Hotel");
        hotel2.setAccommodationType(accommodationType2);

        User user2 = new User();
        user2.setId(3L);
//        user2.setDob("2024-06-11");
        hotel2.setUser(user2);

        RoomType roomType2 = new RoomType();
        roomType2.setId(1L);
        roomType2.setTypeName("DELUX");

        Room room2 = new Room();
        room2.setId(2L);
        room2.setCapacity(1);
        room2.setPrice(80000.0);
        room2.setQuantity(1);
        room2.setRoomSize(1.0);
        room2.setDescription("aaaa");
        room2.setServeBreakfast(true);
        room2.setRoomType(roomType2);
        room2.setRoomFacilities(Arrays.asList(new RoomFacility(2L, null)));

        hotel2.setRooms(Arrays.asList(room2));

        HotelFacility hotelFacility2 = new HotelFacility();
        hotelFacility2.setId(2L);
        Facility facility2 = new Facility();
        facility2.setFacId(1L);
        facility2.setFacType(Fac_Type.HOTEL);
        facility2.setFacName("WiFi");
        facility2.setFacIcon("wifi.png");
        hotelFacility2.setFacility(facility2);
        hotel2.setHotelFacilities(Arrays.asList(hotelFacility2));

        List<GetAllHotelDTO> hotelList = Arrays.asList(hotel1, hotel2);

        // Mock the behavior of the service
        given(getAllHotelUseCase.getAllHotel()).willReturn(hotelList);

        // Perform the GET request and validate the response
        mockMvc.perform(get(END_POINT_PATH)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1L))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].address").value("123 Main St"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].hotelName").value("Hotel Luxury"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].city").value("Hanoi"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].hotelPhoneNum").value("0123456789"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].hotelStars").value(5))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].hotelDescription").value("A luxury hotel"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].status").value("ACTIVE"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[0].checkInTime").value("14:00:00"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[0].checkOutTime").value("12:00:00"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].accommodationType.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].accommodationType.typeName").value("Hotel"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].user.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].user.firstName").value("John"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].user.lastName").value("Doe"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].user.gender").value("MALE"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[0].user.dob").value("1990-01-01"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].hotelImages[0].id").value(1))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[0].hotelImages[0].path").value("hotel1.jpg"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].rooms[0].id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].rooms[0].capacity").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].rooms[0].price").value(100.0))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].rooms[0].quantity").value(10))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].rooms[0].roomSize").value(25.0))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].rooms[0].description").value("A comfortable room"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].rooms[0].serveBreakfast").value(true))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].rooms[0].roomType.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].rooms[0].roomType.typeName").value("DELUX"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].rooms[0].room_images[0].id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].rooms[0].room_images[0].path").value("room1.jpg"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].hotelFacilities[0].id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].hotelFacilities[0].facility.facId").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].hotelFacilities[0].facility.facType").value("HOTEL"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].hotelFacilities[0].facility.facName").value("WiFi"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].hotelFacilities[0].facility.facIcon").value("wifi.png"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].ratings").doesNotExist())
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].id").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].address").value("TP HCM"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].hotelName").value("Mường Thanh"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].city").value("Hồ Chí Minh"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].hotelPhoneNum").value("346135365"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].hotelStars").value(5))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].hotelDescription").value("aaaa"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].status").value("PENDING"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[1].checkInTime").value("04:45:00"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[1].checkOutTime").value("01:45:00"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].accommodationType.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].accommodationType.typeName").value("Hotel"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].user.id").value(3))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[1].user.dob").value("2024-06-11"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].rooms[0].id").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].rooms[0].capacity").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].rooms[0].price").value(80000.0))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].rooms[0].quantity").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].rooms[0].roomSize").value(1.0))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].rooms[0].description").value("aaaa"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].rooms[0].serveBreakfast").value(true))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].rooms[0].roomType.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].rooms[0].roomType.typeName").value("DELUX"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].rooms[0].roomFacilities[0].id").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].hotelFacilities[0].id").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].hotelFacilities[0].facility.facId").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].hotelFacilities[0].facility.facType").value("HOTEL"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].hotelFacilities[0].facility.facName").value("WiFi"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].hotelFacilities[0].facility.facIcon").value("wifi.png"))
                .andDo(print());
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
//        hotel.setCheckInTime("14:00:00");
//        hotel.setCheckOutTime("12:00:00");

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
//                .andExpect(MockMvcResultMatchers.jsonPath("$.checkInTime").value("14:00:00"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.checkOutTime").value("12:00:00"))
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
                .andExpect(MockMvcResultMatchers.content().string(""))
                .andDo(print());
    }
    @Test
    public void testGetAllHotelByUser() throws Exception {
        Long userId = 1L;

        // Create mock data
        GetAllHotelDTO hotel = new GetAllHotelDTO();
        hotel.setId(1L);
        hotel.setAddress("123 Main St");
        hotel.setHotelName("Hotel Luxury");
        hotel.setCity("Hanoi");
        hotel.setHotelPhoneNum("0123456789");
        hotel.setHotelStars(5);
        hotel.setHotelDescription("A luxury hotel");
        hotel.setStatus(Hotel_status.ACTIVE);
//        hotel.setCheckInTime("14:00:00");
//        hotel.setCheckOutTime("12:00:00");

        AccommodationType accommodationType = new AccommodationType();
        accommodationType.setId(1L);
        accommodationType.setTypeName("Hotel");
        hotel.setAccommodationType(accommodationType);

        User user = new User();
        user.setId(1L);
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setGender(Gender.MALE);
//        user.setDob("1990-01-01");
        hotel.setUser(user);

        HotelImage hotelImage = new HotelImage();
        hotelImage.setId(1L);
//        hotelImage.setPath("hotel1.jpg");
//        hotel.setHotelImages(Arrays.asList(hotelImage));

        RoomType roomType = new RoomType();
        roomType.setId(1L);
        roomType.setTypeName("DELUX");

        Room room = new Room();
        room.setId(1L);
        room.setCapacity(2);
        room.setPrice(100.0);
        room.setQuantity(10);
        room.setRoomSize(25.0);
        room.setDescription("A comfortable room");
        room.setServeBreakfast(true);
        room.setRoomType(roomType);

        RoomImage roomImage = new RoomImage();
        roomImage.setId(1L);
//        roomImage.setPath("room1.jpg");
        room.setRoom_images(Arrays.asList(roomImage));

        hotel.setRooms(Arrays.asList(room));

        HotelFacility hotelFacility = new HotelFacility();
        hotelFacility.setId(1L);
        Facility facility = new Facility();
        facility.setFacId(1L);
        facility.setFacType(Fac_Type.HOTEL);
        facility.setFacName("WiFi");
        facility.setFacIcon("wifi.png");
        hotelFacility.setFacility(facility);
        hotel.setHotelFacilities(Arrays.asList(hotelFacility));

        List<GetAllHotelDTO> hotelList = Arrays.asList(hotel);

        // Mock the behavior of the service
        given(hotelService.getAllHotelByUser(userId)).willReturn(hotelList);

        // Perform the GET request and validate the response
        given(hotelService.getAllHotelByUser(userId)).willReturn(hotelList);

        // Perform the GET request and validate the response
        mockMvc.perform(get(END_POINT_PATH+"/partner/getAllHotel/{userId}", userId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").isEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].address").value("123 Main St"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].hotelName").value("Hotel Luxury"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].city").value("Hanoi"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].hotelPhoneNum").value("0123456789"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].hotelStars").value(5))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].hotelDescription").value("A luxury hotel"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].status").value("ACTIVE"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[0].checkInTime").value("14:00:00"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[0].checkOutTime").value("12:00:00"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].accommodationType.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].accommodationType.typeName").value("Hotel"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].user.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].user.firstName").value("John"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].user.lastName").value("Doe"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].user.gender").value("MALE"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[0].user.dob").value("1990-01-01"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].hotelImages[0].id").value(1))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[0].hotelImages[0].path").value("hotel1.jpg"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].rooms[0].id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].rooms[0].capacity").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].rooms[0].price").value(100.0))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].rooms[0].quantity").value(10))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].rooms[0].roomSize").value(25.0))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].rooms[0].description").value("A comfortable room"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].rooms[0].serveBreakfast").value(true))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].rooms[0].roomType.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].rooms[0].roomType.typeName").value("DELUX"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].rooms[0].room_images[0].id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].rooms[0].room_images[0].path").value("room1.jpg"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].hotelFacilities[0].id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].hotelFacilities[0].facility.facId").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].hotelFacilities[0].facility.facType").value("HOTEL"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].hotelFacilities[0].facility.facName").value("WiFi"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].hotelFacilities[0].facility.facIcon").value("wifi.png"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].ratings").doesNotExist())
                .andDo(print());
    }



//    @Test
//    public void testSearchHotels() throws Exception {
//        // Tạo đối tượng GetAllHotelDTO mẫu
//        GetAllHotelDTO hotel1 = new GetAllHotelDTO();
//        hotel1.setId(1L);
//        hotel1.setAddress("123 Main St");
//        hotel1.setHotelName("Hotel Luxury");
//        hotel1.setCity("Hanoi");
//        hotel1.setHotelPhoneNum("0123456789");
//        hotel1.setHotelStars(5);
//        hotel1.setHotelDescription("A luxury hotel");
//
//        GetAllHotelDTO hotel2 = new GetAllHotelDTO();
//        hotel2.setId(2L);
//        hotel2.setAddress("456 Another St");
//        hotel2.setHotelName("Hotel Comfort");
//        hotel2.setCity("Hanoi");
//        hotel2.setHotelPhoneNum("0987654321");
//        hotel2.setHotelStars(4);
//        hotel2.setHotelDescription("A comfortable hotel");
//
//        List<GetAllHotelDTO> hotels = Arrays.asList(hotel1, hotel2);
//
//        // Mock the behavior of the service
//        LocalDate checkinDate = LocalDate.of(2024, 6, 28);
//        LocalDate checkoutDate = LocalDate.of(2024, 6, 30);
//        given(hotelService.searchHotels("Hotel", "Hanoi", checkinDate, checkoutDate, 2, 4)).willReturn(hotels);
//
//        // Perform the GET request and validate the response
//        mockMvc.perform(get("/api/hotels/search")
//                        .param("hotelName", "Hotel")
//                        .param("city", "Hanoi")
//                        .param("checkinDate", "2024-06-28")
//                        .param("checkoutDate", "2024-06-30")
//                        .param("rooms", "2")
//                        .param("capacity", "4")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1L))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[0].address").value(hotel1.getAddress()))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[0].hotelName").value(hotel1.getHotelName()))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[0].city").value(hotel1.getCity()))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[0].hotelPhoneNum").value(hotel1.getHotelPhoneNum()))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[0].hotelStars").value(hotel1.getHotelStars()))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[0].hotelDescription").value(hotel1.getHotelDescription()))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[1].id").value(hotel2.getId().intValue()))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[1].address").value(hotel2.getAddress()))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[1].hotelName").value(hotel2.getHotelName()))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[1].city").value(hotel2.getCity()))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[1].hotelPhoneNum").value(hotel2.getHotelPhoneNum()))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[1].hotelStars").value(hotel2.getHotelStars()))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[1].hotelDescription").value(hotel2.getHotelDescription()))
//                .andDo(print());
//    }

    @Test
    public void testSearchHotelsInvalidDates() throws Exception {
        // Mock the behavior of the service to return false for date validation
        LocalDate checkinDate = LocalDate.of(2024, 6, 30);
        LocalDate checkoutDate = LocalDate.of(2024, 6, 28);
        given(hotelService.validateDates(checkinDate, checkoutDate)).willReturn(false);

        // Perform the GET request and validate the response
        mockMvc.perform(get("/api/hotels/search")
                        .param("hotelName", "Hotel")
                        .param("city", "Hanoi")
                        .param("checkinDate", "2024-06-30")
                        .param("checkoutDate", "2024-06-28")
                        .param("rooms", "2")
                        .param("capacity", "4")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
}