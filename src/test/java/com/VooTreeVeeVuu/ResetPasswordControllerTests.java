package com.VooTreeVeeVuu;

import com.VooTreeVeeVuu.controller.ResetPasswordController;
import com.VooTreeVeeVuu.services.AccountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ResetPasswordControllerTests {

    @Mock
    private MockMvc mockMvc;
    @InjectMocks
    private ResetPasswordController resetPasswordController;
    @Mock
    private AccountService accountService;

    private static final String END_POINT_PATH ="/api/password";
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(resetPasswordController).build();
    }


    @Test
    public void testForgotPassword_Success() throws Exception {
        String email = "thuannnmps26548@fpt.edu.vn";

        // Mock service to do nothing (success case)
        Mockito.doNothing().when(accountService).generateAndSendOTP(email);

        // Send request to POST /forgot and expect success response
        mockMvc.perform(MockMvcRequestBuilders.post(END_POINT_PATH+"/forgot")
                        .param("email", email)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("OTP has sent to your email"))
                .andDo(print());
    }

    @Test
    public void testResetPassword_Success() throws Exception {
        String email = "thuannmps26548@fpt.edu.vn";
        String otp = "123456";
        String newPassword = "321";

        // Mock service to do nothing (success case)
        Mockito.doNothing().when(accountService).resetPassword(email, otp, newPassword);

        // Send request to POST /reset and expect success response
        mockMvc.perform(MockMvcRequestBuilders.post(END_POINT_PATH+"/reset")
                        .param("email", email)
                        .param("otp", otp)
                        .param("newPassword", newPassword)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Password has been reset successfully"))
                .andDo(print());
    }
}
