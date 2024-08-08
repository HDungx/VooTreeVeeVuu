package com.VooTreeVeeVuu;

import com.VooTreeVeeVuu.controller.ChangePhoneNumController;
import com.VooTreeVeeVuu.services.AccountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ChangePhoneNumControllerTest {

    @Mock
    private MockMvc mockMvc;

    @InjectMocks
    private ChangePhoneNumController changePhoneNumController;

    @Mock
    private AccountService accountService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(changePhoneNumController).build();
    }

    @Test
    @DisplayName("Test POST /change-request - Success")
    public void testRequestPhoneNumChangeSuccess() throws Exception {
        // Mock data
        String email = "john.doe@example.com";
        String curPhoneNum = "1234567890";
        String newPhoneNum = "0987654321";

        // Mock service method
        doNothing().when(accountService).requestPhoneNumChange(email, curPhoneNum, newPhoneNum);

        // Perform POST request
        mockMvc.perform(MockMvcRequestBuilders.post("/api/phone/change-request")
                        .param("email", email)
                        .param("curPhoneNum", curPhoneNum)
                        .param("newPhoneNum", newPhoneNum)
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(status().isOk())
                .andExpect(content().string("OTP sent to your email"));
    }

    @Test
    @DisplayName("Test POST /verify - Success")
    public void testVerifyAndChangePhoneNumSuccess() throws Exception {
        // Mock data
        String email = "john.doe@example.com";
        String otp = "123456";
        String newPhoneNum = "0987654321";

        // Mock service method
        doNothing().when(accountService).verifyAndChangePhoneNum(email, otp, newPhoneNum);

        // Perform POST request
        mockMvc.perform(MockMvcRequestBuilders.post("/api/phone/verify")
                        .param("email", email)
                        .param("otp", otp)
                        .param("newPhoneNum", newPhoneNum)
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(status().isOk())
                .andExpect(content().string("Phone number has been changed successfully"));
    }
}
