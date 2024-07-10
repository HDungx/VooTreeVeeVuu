package com.VooTreeVeeVuu;

import com.VooTreeVeeVuu.config.VNPayConfig;
import com.VooTreeVeeVuu.controller.PaymentController;
import com.VooTreeVeeVuu.controller.UserController;
import com.VooTreeVeeVuu.domain.entity.Booking;
import com.VooTreeVeeVuu.domain.entity.User;
import com.VooTreeVeeVuu.domain.repository.UserRepository;
import com.VooTreeVeeVuu.services.PaymentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class PaymentControllerTests {

    @Mock
    private MockMvc mockMvc;

    @InjectMocks
    private PaymentController paymentController;
    @Mock
    private PaymentService paymentService;
    @Mock
    private UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(paymentController).build();
    }


    @Test
    @DisplayName("Test POST /api/payments/create - Success")
    public void testCreatePaymentSuccess() throws Exception {
        // Mock data
        Map<String, String> mockResponse = new HashMap<>();
        mockResponse.put("status", "success");
        mockResponse.put("message", "Payment created successfully");

        // Mock service method
        when(paymentService.createPayment("1000", "VCB", "vn", 1L, 1L, null)).thenReturn(mockResponse);

        // Perform POST request
        mockMvc.perform(post("/api/payments/create")
                        .param("amount", "1000")
                        .param("bankCode", "VCB")
                        .param("language", "vn")
                        .param("bookingId", "1")
                        .param("userId", "1")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("{\"status\":\"success\",\"message\":\"Payment created successfully\"}"));
    }

    @Test
    @DisplayName("Test POST /api/payments/create - Missing Required Parameters")
    public void testCreatePaymentMissingParameters() throws Exception {
        // Perform POST request with missing parameters
        mockMvc.perform(post("/api/payments/create")
                        .param("amount", "1000")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(status().isBadRequest());
    }


    @Test
    @DisplayName("Test POST /api/payments/save-payment - Success")
    public void testCreatePaymentSuccess() throws Exception {
        // Mock data
        Booking mockBooking = new Booking();
        User mockUser = new User();
        String mockTxnRef = "12345678";
        long mockAmountValue = 100000L;
        Date mockCreateDate = new Date();

        // Mock service and repository methods
        when(paymentService.updateBookingStatus(1L)).thenReturn(mockBooking);
        when(userRepository.findById(1L)).thenReturn(Optional.of(mockUser));
        when(VNPayConfig.getRandomNumber(8)).thenReturn(mockTxnRef);

        // Perform POST request
        mockMvc.perform(post("/api/payments/save-payment")
                        .param("amount", "1000")
                        .param("bookingId", "1")
                        .param("userId", "1")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("{\"code\":\"00\",\"message\":\"success\"}"));
    }

    @Test
    @DisplayName("Test POST /api/payments/save-payment - User Not Found")
    public void testCreatePaymentUserNotFound() throws Exception {
        // Mock data
        Booking mockBooking = new Booking();

        // Mock service and repository methods
        when(paymentService.updateBookingStatus(1L)).thenReturn(mockBooking);
        when(userRepository.findById(1L)).thenReturn(Optional.empty());

        // Perform POST request
        mockMvc.perform(post("/api/payments/save-payment")
                        .param("amount", "1000")
                        .param("bookingId", "1")
                        .param("userId", "1")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("Test POST /api/payments/save-payment - Invalid Amount")
    public void testCreatePaymentInvalidAmount() throws Exception {
        // Perform POST request with invalid amount
        mockMvc.perform(post("/api/payments/save-payment")
                        .param("amount", "invalid_amount")
                        .param("bookingId", "1")
                        .param("userId", "1")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(status().isBadRequest());
    }


}
