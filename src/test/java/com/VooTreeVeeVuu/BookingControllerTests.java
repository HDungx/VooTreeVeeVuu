//package com.VooTreeVeeVuu;
//
//import com.VooTreeVeeVuu.controller.BookingController;
//import com.VooTreeVeeVuu.domain.utils.Booking_status;
//import com.VooTreeVeeVuu.dto.BookingDTO;
//import com.VooTreeVeeVuu.services.BookingService;
//import com.VooTreeVeeVuu.usecase.BookingUsecase.GetAllBooking.GetAllBookingImpl;
//import com.VooTreeVeeVuu.usecase.BookingUsecase.GetBooking.GetBookingImpl;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import java.time.LocalDate;
//import java.util.Arrays;
//import java.util.Optional;
//
//import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//public class BookingControllerTests {
//
//    @Mock
//    private MockMvc mockMvc;
//
//    @InjectMocks
//    private BookingController bookingController;
//    @Mock
//    private GetAllBookingImpl getAllBookingUseCase;
//    @Mock
//    private GetBookingImpl getBookingUseCase;
//
//    @Mock
//    private BookingService bookingService;
//    private static final String END_POINT_PATH="/api/bookings";
//    @BeforeEach
//    public void setUp() {
//        MockitoAnnotations.openMocks(this);
//        mockMvc = MockMvcBuilders.standaloneSetup(bookingController).build();
//    }
//
//
//    @Test
//    public void getAllBookingTest() throws Exception {
//        // Arrange
//        BookingDTO booking = new BookingDTO(
//                1L,
//                LocalDate.of(2024, 6, 21),
//                LocalDate.of(2024, 6, 22),
//                200.0,
//                "john_doe",
//                "Hotel Luxury",
//                "DELUX",
//                "123 Main St",
//                1L,
//                Booking_status.PENDING,
//                1,
//                2,
//                LocalDate.of(2024, 6, 20)
//        );
//
//        Mockito.when(getAllBookingUseCase.getAllBooking()).thenReturn(Arrays.asList(booking));
//
//        // Act & Assert
//        mockMvc.perform(MockMvcRequestBuilders.get(END_POINT_PATH)
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$[0].id").value(1L))
////                .andExpect(jsonPath("$[0].checkInDate").value("2024-06-21"))
////                .andExpect(jsonPath("$[0].checkOutDate").value("2024-06-22"))
//                .andExpect(jsonPath("$[0].totalPrice").value(200.0))
//                .andExpect(jsonPath("$[0].userName").value("john_doe"))
//                .andExpect(jsonPath("$[0].hotelName").value("Hotel Luxury"))
//                .andExpect(jsonPath("$[0].roomType").value("DELUX"))
//                .andExpect(jsonPath("$[0].address").value("123 Main St"))
//                .andExpect(jsonPath("$[0].hotelOwnerId").value(1L))
//                .andExpect(jsonPath("$[0].status").value("PENDING"))
//                .andExpect(jsonPath("$[0].numOfRoom").value(1))
//                .andExpect(jsonPath("$[0].numOfGuest").value(2))
////                .andExpect(jsonPath("$[0].bookingDate").value("2024-06-20"))
//                .andDo(print());
//    }
//
//
//    @Test
//    public void getBookingByIdTest() throws Exception {
//        // Arrange
//        BookingDTO booking = new BookingDTO(
//                1L,
//                LocalDate.of(2024, 6, 21),
//                LocalDate.of(2024, 6, 22),
//                200.0,
//                null,
//                null,
//                null,
//                null,
//                null,
//                Booking_status.PENDING,
//                1,
//                2,
//                LocalDate.of(2024, 6, 20)
//        );
//
//        Mockito.when(getBookingUseCase.getBookingById(1L)).thenReturn(Optional.of(booking));
//
//        // Act & Assert
//        mockMvc.perform(MockMvcRequestBuilders.get(END_POINT_PATH+"/1")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.id").value(1L))
////                .andExpect(jsonPath("$.checkInDate").value("2024-06-21"))
////                .andExpect(jsonPath("$.checkOutDate").value("2024-06-22"))
//                .andExpect(jsonPath("$.totalPrice").value(200.0))
//                .andExpect(jsonPath("$.userName").isEmpty())
//                .andExpect(jsonPath("$.hotelName").isEmpty())
//                .andExpect(jsonPath("$.roomType").isEmpty())
//                .andExpect(jsonPath("$.address").isEmpty())
//                .andExpect(jsonPath("$.hotelOwnerId").isEmpty())
//                .andExpect(jsonPath("$.status").value("PENDING"))
//                .andExpect(jsonPath("$.numOfRoom").value(1))
//                .andExpect(jsonPath("$.numOfGuest").value(2))
////                .andExpect(jsonPath("$.bookingDate").value("2024-06-20"))
//                .andDo(print());
//    }
//
//
//    @Test
//    public void getUserBookingHistoryTest() throws Exception {
//        // Arrange
//        BookingDTO booking = new BookingDTO(
//                1L,
//                LocalDate.of(2024, 6, 21),
//                LocalDate.of(2024, 6, 22),
//                200.0,
//                "john_doe",
//                "Hotel Luxury",
//                "DELUX",
//                "123 Main St",
//                null,
//                Booking_status.PAID,
//                1,
//                2,
//                LocalDate.of(2024, 6, 20)
//        );
//
//        Mockito.when(bookingService.getUserBookingHistory(1L)).thenReturn(Arrays.asList(booking));
//
//        // Act & Assert
//        mockMvc.perform(MockMvcRequestBuilders.get(END_POINT_PATH+"/1/booking-history")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$[0].id").value(1L))
////                .andExpect(jsonPath("$[0].checkInDate").value("2024-06-21"))
////                .andExpect(jsonPath("$[0].checkOutDate").value("2024-06-22"))
//                .andExpect(jsonPath("$[0].totalPrice").value(200.0))
//                .andExpect(jsonPath("$[0].userName").value("john_doe"))
//                .andExpect(jsonPath("$[0].hotelName").value("Hotel Luxury"))
//                .andExpect(jsonPath("$[0].roomType").value("DELUX"))
//                .andExpect(jsonPath("$[0].address").value("123 Main St"))
//                .andExpect(jsonPath("$[0].hotelOwnerId").isEmpty())
//                .andExpect(jsonPath("$[0].status").value("PAID"))
//                .andExpect(jsonPath("$[0].numOfRoom").value(1))
//                .andExpect(jsonPath("$[0].numOfGuest").value(2))
////                .andExpect(jsonPath("$[0].bookingDate").value("2024-06-20"))
//                .andDo(print());
//    }
//
//    @Test
//    public void createBookingTest() throws Exception{
//
//    }
//}
