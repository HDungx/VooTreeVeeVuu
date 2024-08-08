package com.VooTreeVeeVuu;

import com.VooTreeVeeVuu.controller.RoomTypeController;
import com.VooTreeVeeVuu.domain.entity.Room;
import com.VooTreeVeeVuu.domain.entity.RoomType;
import com.VooTreeVeeVuu.dto.RoomTypeDTO;
import com.VooTreeVeeVuu.usecase.RoomTypeUsecase.CreateRoomType.CreateRoomTypeImpl;
import com.VooTreeVeeVuu.usecase.RoomTypeUsecase.DeleteRoomType.DeleteRoomTypeImpl;
import com.VooTreeVeeVuu.usecase.RoomTypeUsecase.GetAllRoomType.GetAllRoomTypeImpl;
import com.VooTreeVeeVuu.usecase.RoomTypeUsecase.GetRoomType.GetRoomTypeImpl;
import com.VooTreeVeeVuu.usecase.RoomTypeUsecase.UpdateRoomType.UpdateRoomTypeImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class RoomTypeControllerTest {
    @Mock
    private MockMvc mockMvc;

    @InjectMocks
    private RoomTypeController roomTypeController;

    @Mock
    private CreateRoomTypeImpl createRoomTypeUseCase;

    @Mock
    private UpdateRoomTypeImpl updateRoomTypeUseCase;

    @Mock
    private DeleteRoomTypeImpl deleteRoomTypeUseCase;

    @Mock
    private GetAllRoomTypeImpl getAllRoomTypeUseCase;

    @Mock
    private GetRoomTypeImpl getRoomTypeUseCase;

    @Mock
    private ObjectMapper objectMapper;
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(roomTypeController).build();
    }

    @Test
    public void testGetAllRoomTypes() throws Exception {
        // Mock data
        RoomTypeDTO deluxRoomType = new RoomTypeDTO(1L, "DELUX", Arrays.asList(
                new Room(1L, 2, 100.0, 10, 25.0, true, new RoomType(1L, "DELUX"), null, null, null)
        ));
        RoomTypeDTO premiumRoomType = new RoomTypeDTO(2L, "PREMIUM", null);
        RoomTypeDTO vipRoomType = new RoomTypeDTO(3L, "VIP", null);
        RoomTypeDTO defaultRoomType = new RoomTypeDTO(4L, "DEFAULT", null);

        // Mock service response
        given(getAllRoomTypeUseCase.getAllRoomTypes()).willReturn(Arrays.asList(
                deluxRoomType, premiumRoomType, vipRoomType, defaultRoomType
        ));

        // Perform GET request and verify the response
        mockMvc.perform(get("/api/roomTypes")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1L))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].typeName").value("DELUX"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].rooms[0].id").value(1L))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].rooms[0].capacity").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].rooms[0].price").value(100.0))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].rooms[0].quantity").value(10))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].rooms[0].roomSize").value(25.0))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].rooms[0].serveBreakfast").value(true))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].rooms[0].roomType.id").value(1L))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].rooms[0].roomType.typeName").value("DELUX"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].id").value(2L))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].typeName").value("PREMIUM"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].id").value(3L))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].typeName").value("VIP"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[3].id").value(4L))
                .andExpect(MockMvcResultMatchers.jsonPath("$[3].typeName").value("DEFAULT"))
                .andDo(print());
        // Verify that getAllRoomTypes() method was called exactly once
        verify(getAllRoomTypeUseCase, times(1)).getAllRoomTypes();
    }


    @Test
    public void testGetRoomTypeById_Valid() throws Exception {
        // Mock data
        Long roomTypeId = 1L;
        RoomTypeDTO deluxRoomType = new RoomTypeDTO(roomTypeId, "DELUX", Arrays.asList(
                new Room(1L, 2, 100.0, 10, 25.0,  true, new RoomType(roomTypeId, "DELUX"), null, null, null)
        ));

        // Mock service response
        given(getRoomTypeUseCase.getRoomTypeById(roomTypeId)).willReturn(Optional.of(deluxRoomType));

        // Perform GET request and verify the response
        mockMvc.perform(get("/api/roomTypes/{id}", roomTypeId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1L))
                .andExpect(MockMvcResultMatchers.jsonPath("$.typeName").value("DELUX"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.rooms[0].id").value(1L))
                .andExpect(MockMvcResultMatchers.jsonPath("$.rooms[0].capacity").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$.rooms[0].price").value(100.0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.rooms[0].quantity").value(10))
                .andExpect(MockMvcResultMatchers.jsonPath("$.rooms[0].roomSize").value(25.0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.rooms[0].serveBreakfast").value(true))
                .andExpect(MockMvcResultMatchers.jsonPath("$.rooms[0].roomType.id").value(1L))
                .andExpect(MockMvcResultMatchers.jsonPath("$.rooms[0].roomType.typeName").value("DELUX"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.rooms[0].roomFacilities").isEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$.rooms[0].room_images").isEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$.rooms[0].status").doesNotExist())
                .andDo(print());

        // Verify that getRoomTypeById() method was called exactly once
        verify(getRoomTypeUseCase, times(1)).getRoomTypeById(roomTypeId);
    }

}
