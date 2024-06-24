//package com.VooTreeVeeVuu;
//
//import com.VooTreeVeeVuu.controller.ResetPasswordController;
//import com.VooTreeVeeVuu.services.AccountService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//public class ResetPasswordControllerTests {
//
//    @Mock
//    private MockMvc mockMvc;
//    @InjectMocks
//    private ResetPasswordController resetPasswordController;
//    @Mock
//    private AccountService accountService;
//
//    @BeforeEach
//    public void setUp() {
//        MockitoAnnotations.openMocks(this);
//        mockMvc = MockMvcBuilders.standaloneSetup(resetPasswordController).build();
//    }
//
//    @Test
//    public void testForgotPassword_Success() throws Exception {
//        String email = "test@example.com";
//
//        // Perform the POST request
//        mockMvc.perform(post("/forgot")
//                        .param("email", email)
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(content().string("OTP has sent to your email"));
//
//        // Verify that the generateAndSendOTP method was called
//        verify(accountService).generateAndSendOTP(email);
//    }
//
////    @Test
////    public void testForgotPassword_InvalidEmail() throws Exception {
////        String invalidEmail = "invalid@example.com";
////        String errorMessage = "Invalid email address";
////
////        // Mock the service to throw an IllegalArgumentException
////        doThrow(new IllegalArgumentException(errorMessage)).when(accountService).generateAndSendOTP(invalidEmail);
////
////        // Perform the POST request
////        mockMvc.perform(post("/forgot")
////                        .param("email", invalidEmail)
////                        .contentType(MediaType.APPLICATION_JSON))
////                .andExpect(status().isBadRequest())
////                .andExpect(content().string(errorMessage));
////
////        // Verify that the generateAndSendOTP method was called
////        verify(accountService).generateAndSendOTP(invalidEmail);
////    }
//
//}
