package com.VooTreeVeeVuu;

import com.VooTreeVeeVuu.config.VNPayConfig;
import com.VooTreeVeeVuu.controller.PaymentController;
import com.VooTreeVeeVuu.domain.entity.Booking;
import com.VooTreeVeeVuu.domain.entity.User;
import com.VooTreeVeeVuu.domain.repository.UserRepository;
import com.VooTreeVeeVuu.services.PaymentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import jakarta.servlet.http.HttpServletRequest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class PaymentControllerTests {

    @Mock
    private PaymentService paymentService;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private PaymentController paymentController;

    @Mock
    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(paymentController).build();
    }

    @Test
    public void testCreatePayment_Success() throws Exception {
        // Arrange
        String amount = "100.00";
        String bankCode = "BANK123";
        String language = "EN";
        Long bookingId = 1L;
        Long userId = 1L;

        Map<String, String> paymentResponse = new HashMap<>();
        paymentResponse.put("status", "success");
        paymentResponse.put("message", "Payment created successfully");

        when(paymentService.createPayment(anyString(), anyString(), anyString(), anyLong(), anyLong(), any(HttpServletRequest.class)))
                .thenReturn(paymentResponse);

        // Act & Assert
        mockMvc.perform(post("/api/payment/create")
                        .param("amount", amount)
                        .param("bankCode", bankCode)
                        .param("language", language)
                        .param("bookingId", bookingId.toString())
                        .param("userId", userId.toString())
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("{\"status\":\"success\",\"message\":\"Payment created successfully\"}"));
    }

    @Test
    public void testSavePayment_Success() throws Exception {
        // Arrange
        String amount = "100.00";
        Long bookingId = 1L;
        Long userId = 1L;

        Booking booking = new Booking(); // Replace with your actual Booking class and setup
        User user = new User(); // Replace with your actual User class and setup

        when(paymentService.updateBookingStatus(anyLong())).thenReturn(booking);
        when(userRepository.findById(anyLong())).thenReturn(Optional.of(user));

        // Act & Assert
        mockMvc.perform(post("/api/payment/save-payment")
                        .param("amount", amount)
                        .param("bookingId", bookingId.toString())
                        .param("userId", userId.toString())
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("{\"code\":\"00\",\"message\":\"success\"}"));
    }
}
