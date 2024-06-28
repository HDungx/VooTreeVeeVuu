package com.VooTreeVeeVuu;

import com.VooTreeVeeVuu.controller.RoomFacilityController;
import com.VooTreeVeeVuu.usecase.RoomFacilityUsecase.DeleteRoomFacility.DeleteRoomFacilityImpl;
import com.VooTreeVeeVuu.usecase.RoomFacilityUsecase.GetAllRoomFacility.GetAllRoomFacilityImpl;
import com.VooTreeVeeVuu.usecase.RoomFacilityUsecase.GetRoomFacility.GetRoomFacilityImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class RoomFacilityControllerTest {
    @Mock
    private MockMvc mockMvc;
    @InjectMocks
    private RoomFacilityController facilityController;

    @Mock
    private DeleteRoomFacilityImpl deleteRoomFacilityUseCase;

    @Mock
    private GetAllRoomFacilityImpl getAllRoomFacilityUseCase;

    @Mock
    private GetRoomFacilityImpl getRoomFacilityUseCase;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(facilityController).build();
    }
private static final String END_POINT_PATH ="/api/roomFacilities";
    @Test
    public void testDeleteRoomFacility_Success() throws Exception {
        Long id = 1L;

        // Mock service to do nothing (success case)
        doNothing().when(deleteRoomFacilityUseCase).deleteRoomFacility(id);

        // Send request to DELETE /delete/{id} and expect success response
        mockMvc.perform(MockMvcRequestBuilders.delete(END_POINT_PATH+"/delete/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }
}
