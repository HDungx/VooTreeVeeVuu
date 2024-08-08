package com.VooTreeVeeVuu;

import com.VooTreeVeeVuu.controller.AuthenticationController;
import com.VooTreeVeeVuu.controller.RoleController;
import com.VooTreeVeeVuu.dto.AuthenticationResponse;
import com.VooTreeVeeVuu.dto.LoginDTO;
import com.VooTreeVeeVuu.dto.SignUpDTO;
import com.VooTreeVeeVuu.services.AuthenticationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.util.Set;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class AuthControllerTests {
    @Mock
    private MockMvc mockMvc;
    @InjectMocks
    private AuthenticationController authenticationController;
    @InjectMocks
    private RoleController roleController;
    @Mock
    private AuthenticationService authService;

    private static final String END_POINT_PATH ="/api/auth";

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(authenticationController).build();
    }

    @Test
    public void testRegister() throws Exception {
        SignUpDTO signUpDTO = SignUpDTO.builder()
                .username("String1")
                .password("String21")
                .email("String21@gmail.com")
                .phone("0346112265")
                .firstName("String")
                .lastName("String")
                .roles(Set.of("CUSTOMER"))
                .status(true)
                .build();
        ObjectMapper om = new ObjectMapper();
        String authJson = om.writeValueAsString(signUpDTO);
        AuthenticationResponse authResponse = AuthenticationResponse.builder()
                .token("fake-jwt-token")
                .build();

        when(authService.register(any(SignUpDTO.class))).thenReturn(authResponse);

        mockMvc.perform(post(END_POINT_PATH+"/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(authJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.token").value("fake-jwt-token"))
                .andDo(print());
    }

    @Test
    public void testLogin() throws Exception {
        LoginDTO loginDTO = LoginDTO.builder()
                .username("String21@gmail.com")
                .password("String21")
                .date(LocalDate.now())
                .build();

        AuthenticationResponse authResponse = AuthenticationResponse.builder()
                .token("fake-jwt-token")
                .build();

        when(authService.login(any(LoginDTO.class))).thenReturn(authResponse);

        ObjectMapper om = new ObjectMapper();
        om.registerModule(new JavaTimeModule());

        String loginJson = om.writeValueAsString(loginDTO);

        mockMvc.perform(post(END_POINT_PATH+"/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(loginJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.token").value("fake-jwt-token"))
                .andDo(print());
        }
}
