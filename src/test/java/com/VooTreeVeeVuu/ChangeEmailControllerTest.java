package com.VooTreeVeeVuu;

import com.VooTreeVeeVuu.controller.ChangeEmailController;
import com.VooTreeVeeVuu.services.AccountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.*;

public class ChangeEmailControllerTest {

    @Mock
    private MockMvc mockMvc;
    @InjectMocks
    private ChangeEmailController changeEmailController;
    @Mock
    private AccountService accountService;

    private static final String END_POINT_PATH="/api/email";

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(changeEmailController).build();
    }

    @Test
    public void testRequestEmailChange_Success() throws Exception {
        // Arrange
        String curEmail = "john.doe@example.com";
        String newEmail = "thuannnmps26548@fpt.edu.vn";

        // Mock the service method to return successful response
        doNothing().when(accountService).requestEmailChange(anyString(), anyString());

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.post("/api/email/change-request")
                        .param("curEmail", curEmail)
                        .param("newEmail", newEmail)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("OTP sent to your new email"));

        // Verify that the service method was called with the expected parameters
        verify(accountService, times(1)).requestEmailChange(curEmail, newEmail);
    }

    @Test
    public void testRequestEmailChange_Failure() throws Exception {
        // Arrange
        String curEmail = "john.doe@example.com";
        String newEmail = "thuannnmps26548@fpt.edu.vn";

        // Mock the service method to throw an IllegalArgumentException
        doThrow(new IllegalArgumentException("Invalid email")).when(accountService).requestEmailChange(anyString(), anyString());

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.post("/api/email/change-request")
                        .param("curEmail", curEmail)
                        .param("newEmail", newEmail)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().string("Invalid email"));

        // Verify that the service method was called with the expected parameters
        verify(accountService, times(1)).requestEmailChange(curEmail, newEmail);
    }
    @Test
    public void testVerifyAndChangeEmail_Success() throws Exception {
        // Arrange
        String curEmail = "john.doe@example.com";
        String otp = "123456";
        String newEmail = "thuannnmps26548@fpt.edu.vn";

        // Mock the service method to return successful response
        doNothing().when(accountService).verifyAndChangeEmail(anyString(), anyString(), anyString());

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.post("/api/email/verify")
                        .param("curEmail", curEmail)
                        .param("otp", otp)
                        .param("newEmail", newEmail)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Email has been changed successfully"));

        // Verify that the service method was called with the expected parameters
        verify(accountService, times(1)).verifyAndChangeEmail(curEmail, otp, newEmail);
    }

    @Test
    public void testVerifyAndChangeEmail_Failure() throws Exception {
        // Arrange
        String curEmail = "john.doe@example.com";
        String otp = "123456";
        String newEmail = "thuannnmps26548@fpt.edu.vn";

        // Mock the service method to throw an IllegalArgumentException
        doThrow(new IllegalArgumentException("OTP has expired")).when(accountService).verifyAndChangeEmail(anyString(), anyString(), anyString());

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.post("/api/email/verify")
                        .param("curEmail", curEmail)
                        .param("otp", otp)
                        .param("newEmail", newEmail)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().string("OTP has expired"));

        // Verify that the service method was called with the expected parameters
        verify(accountService, times(1)).verifyAndChangeEmail(curEmail, otp, newEmail);
    }
}
