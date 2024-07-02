package com.VooTreeVeeVuu;

import com.VooTreeVeeVuu.controller.LogsController;
import com.VooTreeVeeVuu.domain.entity.Hotel;
import com.VooTreeVeeVuu.domain.entity.User;
import com.VooTreeVeeVuu.domain.utils.Action;
import com.VooTreeVeeVuu.dto.LogsDTO;
import com.VooTreeVeeVuu.usecase.LogsUsecase.CreateLogs.CreateLogsImpl;
import com.VooTreeVeeVuu.usecase.LogsUsecase.DeleteLogs.DeleteLogsImpl;
import com.VooTreeVeeVuu.usecase.LogsUsecase.GetAllLogs.GetAllLogsImpl;
import com.VooTreeVeeVuu.usecase.LogsUsecase.GetLogs.GetLogsImpl;
import com.VooTreeVeeVuu.usecase.LogsUsecase.UpdateLogs.UpdateLogsImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class LogsControllerTest {
    @Mock
    private MockMvc mockMvc;

    @InjectMocks
    private LogsController logsController;

    private CreateLogsImpl createLogsUseCase;

    @Mock
    private UpdateLogsImpl updateLogsUseCase;

    @Mock
    private DeleteLogsImpl deleteLogsUseCase;

    @Mock
    private GetAllLogsImpl getAllLogsUseCase;

    @Mock
    private GetLogsImpl getLogsUseCase;


    @Mock
    private ObjectMapper objectMapper;
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(logsController).build();
    }

    @Test
    @DisplayName("Test GET /logs - Success")
    public void testGetAllLogs() throws Exception {
        // Mock data
        Hotel hotel = new Hotel(1L, "123 Street", "Hotel Name", "City", "123456789", 5, "Description", null, null, null, null);
        User user = new User(1L, "John", "Doe", null, LocalDate.of(1990, 1, 1));
        LogsDTO log1 = new LogsDTO(1L, Action.CREATE, LocalDate.of(2023, 7, 1), hotel, user);
        LogsDTO log2 = new LogsDTO(2L, Action.UPDATE, LocalDate.of(2023, 7, 2), hotel, user);

        List<LogsDTO> logs = Arrays.asList(log1, log2);

        // Mock use case method
        when(getAllLogsUseCase.getAllLogs()).thenReturn(logs);

        // Perform GET request
        mockMvc.perform(get("/api/logs"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(logs.size()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(log1.getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].action").value(log1.getAction().toString()))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[0].date").value(log1.getDate().toString()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].hotel.id").value(log1.getHotel().getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].user.id").value(log1.getUser().getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].id").value(log2.getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].action").value(log2.getAction().toString()))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[1].date").value(log2.getDate().toString()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].hotel.id").value(log2.getHotel().getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].user.id").value(log2.getUser().getId()));
    }

    @Test
    @DisplayName("Test GET /logs/{id} - Success")
    public void testGetLogsByIdSuccess() throws Exception {
        // Mock data
        Long logId = 1L;
        Hotel hotel = new Hotel(1L, "123 Street", "Hotel Name", "City", "123456789", 5, "Description", null, null, null, null);
        User user = new User(1L, "John", "Doe", null, LocalDate.of(1990, 1, 1));
        LogsDTO log = new LogsDTO(logId, Action.CREATE, LocalDate.of(2023, 7, 1), hotel, user);

        // Mock use case method
        when(getLogsUseCase.getLogsById(logId)).thenReturn(Optional.of(log));

        // Perform GET request
        mockMvc.perform(get("/api/logs/{id}", logId))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(log.getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.action").value(log.getAction().toString()))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.date").value(log.getDate().toString()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.hotel.id").value(log.getHotel().getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user.id").value(log.getUser().getId()));
    }


    @Test
    @DisplayName("Test GET /logs/{id} - Not Found")
    public void testGetLogsByIdNotFound() throws Exception {
        // Mock data
        Long logId = 1L;

        // Mock use case method
        when(getLogsUseCase.getLogsById(logId)).thenReturn(Optional.empty());

        // Perform GET request
        mockMvc.perform(get("/logs/{id}", logId))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("Test POST /logs - Success")
    public void testCreateLogsSuccess() throws Exception {
        // Mock data
        Long logId = 1L;
        Hotel hotel = new Hotel(1L, "123 Street", "Hotel Name", "City", "123456789", 5, "Description", null, null, null, null);
        User user = new User(1L, "John", "Doe", null, LocalDate.of(1990, 1, 1));
        LogsDTO log = new LogsDTO(logId, Action.CREATE, LocalDate.of(2023, 7, 1), hotel, user);
        String logJson = objectMapper.writeValueAsString(log);

        // Mock use case method
        when(createLogsUseCase.createLogs(log)).thenReturn(log);

        // Perform POST request
        mockMvc.perform(post("/api/logs")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(logJson))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(log.getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.action").value(log.getAction().toString()))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.date").value(log.getDate().toString()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.hotel.id").value(log.getHotel().getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user.id").value(log.getUser().getId()));
    }


    @Test
    @DisplayName("Test PUT /logs/update/{id} - Success")
    public void testUpdateLogsSuccess() throws Exception {
        // Mock data
        Long logId = 1L;
        Hotel hotel = new Hotel(1L, "123 Street", "Hotel Name", "City", "123456789", 5, "Description", null, null, null, null);
        User user = new User(1L, "John", "Doe", null, LocalDate.of(1990, 1, 1));
        LogsDTO log = new LogsDTO(logId, Action.UPDATE, LocalDate.of(2023, 7, 1), hotel, user);
        String logJson = objectMapper.writeValueAsString(log);

        // Mock use case method
        when(updateLogsUseCase.updateLogs(logId, log)).thenReturn(Optional.of(log));

        // Perform PUT request
        mockMvc.perform(put("/api/logs/update/{id}", logId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(logJson))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(log.getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.action").value(log.getAction().toString()))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.date").value(log.getDate().toString()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.hotel.id").value(log.getHotel().getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user.id").value(log.getUser().getId()));
    }


    @Test
    @DisplayName("Test DELETE /logs/delete/{id} - Success")
    public void testDeleteLogsSuccess() throws Exception {
        // Mock data
        Long logId = 1L;

        // Mock use case method
        doNothing().when(deleteLogsUseCase).deleteLogs(logId);

        // Perform DELETE request
        mockMvc.perform(delete("/api/logs/delete/{id}", logId))
                .andExpect(status().isOk());

        // Verify the interaction
        verify(deleteLogsUseCase).deleteLogs(logId);
    }
}
