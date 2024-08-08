package com.VooTreeVeeVuu;

import com.VooTreeVeeVuu.controller.EmailSenderController;
import com.VooTreeVeeVuu.dto.EmailReceiptDTO;
import com.VooTreeVeeVuu.services.EmailService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalTime;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class EmailSenderControllerTests {
    @Mock
    private MockMvc mockMvc;

    @InjectMocks
    private EmailSenderController emailSenderController;
    @Mock
    private EmailService emailService;
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(emailSenderController).build();
    }

    @Test
    @DisplayName("Test POST /api/email-sender/send-receipt - Success")
    public void testSendReceiptSuccess() throws Exception {
        // Mock data
        EmailReceiptDTO emailReceiptDTO = new EmailReceiptDTO(
                "Hotel Paradise",
                "Deluxe",
                "123 Beach Road",
                "customer@example.com",
                "2023-07-01",
                "123456789",
                "2023-07-07",
                LocalTime.of(14, 0),
                LocalTime.of(11, 0),
                2,
                4,
                5000L,
                "John Doe",
                "987654321",
                "owner@example.com"
        );

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        // Mock service method
        doNothing().when(emailService).sendEmailReceipt(emailReceiptDTO);

        // Perform POST request
        mockMvc.perform(post("/api/email-sender/send-receipt")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(emailReceiptDTO)))
                .andExpect(status().isOk());
        verify(emailService, times(1)).sendEmailReceipt(any(EmailReceiptDTO.class));
    }


    @Test
    @DisplayName("Test POST /api/email-sender/send-info - Success")
    public void testSendInfoSuccess() throws Exception {
        // Mock data
        EmailReceiptDTO emailReceiptDTO = new EmailReceiptDTO(
                "Hotel Paradise",
                "Deluxe",
                "123 Beach Road",
                "customer@example.com",
                "2023-07-01",
                "123456789",
                "2023-07-07",
                LocalTime.of(14, 0),
                LocalTime.of(11, 0),
                2,
                4,
                5000L,
                "John Doe",
                "987654321",
                "owner@example.com"
        );

	    ObjectMapper objectMapper = new ObjectMapper();
	    objectMapper.registerModule(new JavaTimeModule());

        // Convert DTO to JSON string
        String emailReceiptJson = objectMapper.writeValueAsString(emailReceiptDTO);

        // Mock service method
        doNothing().when(emailService).sendEmailToOwner(emailReceiptDTO);

        // Perform POST request
        mockMvc.perform(post("/api/email-sender/send-info")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(emailReceiptJson))
                .andExpect(status().isOk());
    }
}
