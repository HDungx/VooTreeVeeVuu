package com.VooTreeVeeVuu;

import com.VooTreeVeeVuu.controller.FacilityController;
import com.VooTreeVeeVuu.domain.entity.HotelFacility;
import com.VooTreeVeeVuu.domain.entity.RoomFacility;
import com.VooTreeVeeVuu.domain.utils.Fac_Type;
import com.VooTreeVeeVuu.dto.FacilityDTO;
import com.VooTreeVeeVuu.usecase.FacilityUsecase.CreateFacility.CreateFacilityImpl;
import com.VooTreeVeeVuu.usecase.FacilityUsecase.DeleteFacility.DeleteFacilityImpl;
import com.VooTreeVeeVuu.usecase.FacilityUsecase.GetAllFacility.GetAllFacilityImpl;
import com.VooTreeVeeVuu.usecase.FacilityUsecase.GetFacility.GetFacilityImpl;
import com.VooTreeVeeVuu.usecase.FacilityUsecase.UpdateFacility.UpdateFacilityImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class FacilityControllerTests {
    @Mock
    private MockMvc mockMvc;

    @InjectMocks
    private FacilityController facilityController;
    @Mock
    private CreateFacilityImpl createFacilityUseCase;

    @Mock
    private UpdateFacilityImpl updateFacilityUseCase;

    @Mock
    private DeleteFacilityImpl deleteFacilityUseCase;

    @Mock
    private GetAllFacilityImpl getAllFacilityUseCase;

    @Mock
    private GetFacilityImpl getFacilityUseCase;
    private static final String END_POINT_PATH = "/api/facilities";

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(facilityController).build();
    }


    @Test
    public void getAllFacilityTest() throws Exception {
        // Arrange
        FacilityDTO facility1 = new FacilityDTO(1L, Fac_Type.HOTEL, "WiFi", "icon1.png", null, null);
        FacilityDTO facility2 = new FacilityDTO(2L, Fac_Type.ROOM, "Air Conditioning", "icon2.png", null, null);
        List<FacilityDTO> facilities = Arrays.asList(facility1, facility2);

        when(getAllFacilityUseCase.getAllFacility()).thenReturn(facilities);

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.get(END_POINT_PATH)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].facId").value(1L))
                .andExpect(jsonPath("$[0].facType").value("HOTEL"))
                .andExpect(jsonPath("$[0].facName").value("WiFi"))
                .andExpect(jsonPath("$[0].facIcon").value("icon1.png"))
                .andExpect(jsonPath("$[0].hotelFacility").isEmpty())
                .andExpect(jsonPath("$[0].roomFacility").isEmpty())
                .andExpect(jsonPath("$[1].facId").value(2L))
                .andExpect(jsonPath("$[1].facType").value("ROOM"))
                .andExpect(jsonPath("$[1].facName").value("Air Conditioning"))
                .andExpect(jsonPath("$[1].facIcon").value("icon2.png"))
                .andExpect(jsonPath("$[1].hotelFacility").isEmpty())
                .andExpect(jsonPath("$[1].roomFacility").isEmpty())
                .andDo(print());
    }

    @Test
    public void getFacilityByIdTest() throws Exception {
        // Arrange
        FacilityDTO facility = new FacilityDTO(1L, Fac_Type.HOTEL, "WiFi", "icon1.png", null, null);
        when(getFacilityUseCase.getFacilityById(1L)).thenReturn(Optional.of(facility));

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.get(END_POINT_PATH + "/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.facId").value(1L))
                .andExpect(jsonPath("$.facType").value("HOTEL"))
                .andExpect(jsonPath("$.facName").value("WiFi"))
                .andExpect(jsonPath("$.facIcon").value("icon1.png"))
                .andExpect(jsonPath("$.hotelFacility").isEmpty())
                .andExpect(jsonPath("$.roomFacility").isEmpty())
                .andDo(print());
    }

    @Test
    public void testCreateFacility() throws Exception {
        // Arrange
        FacilityDTO facilityDTO = new FacilityDTO();
        facilityDTO.setFacId(1L);
        facilityDTO.setFacType(Fac_Type.HOTEL);
        facilityDTO.setFacName("Pool");
        facilityDTO.setFacIcon("icon-pool.png");
        facilityDTO.setHotelFacility(new HotelFacility());  // Set appropriate properties
        facilityDTO.setRoomFacility(new RoomFacility());    // Set appropriate properties

        when(createFacilityUseCase.createFacility(any(FacilityDTO.class))).thenReturn(facilityDTO);

        ObjectMapper objectMapper = new ObjectMapper();

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.post("/api/facilities")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(facilityDTO)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(objectMapper.writeValueAsString(facilityDTO)));

        verify(createFacilityUseCase, times(1)).createFacility(any(FacilityDTO.class));
    }

    @Test
    public void testUpdateFacility() throws Exception {
        // Arrange
        Long facilityId = 1L;
        FacilityDTO facilityDTO = new FacilityDTO();
        facilityDTO.setFacId(facilityId);
        facilityDTO.setFacType(Fac_Type.HOTEL);
        facilityDTO.setFacName("Gym");
        facilityDTO.setFacIcon("icon-gym.png");
        facilityDTO.setHotelFacility(new HotelFacility());  // Set appropriate properties
        facilityDTO.setRoomFacility(new RoomFacility());    // Set appropriate properties

        when(updateFacilityUseCase.updateFacility(anyLong(), any(FacilityDTO.class))).thenReturn(Optional.of(facilityDTO));

        ObjectMapper objectMapper = new ObjectMapper();

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.put("/api/facilities/update/{id}", facilityId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(facilityDTO)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(objectMapper.writeValueAsString(facilityDTO)));

        verify(updateFacilityUseCase, times(1)).updateFacility(anyLong(), any(FacilityDTO.class));
    }

    @Test
    public void testDeleteFacility() throws Exception {
        // Arrange
        Long facilityId = 1L;

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/facilities/delete/{id}", facilityId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(deleteFacilityUseCase, times(1)).deleteFacility(anyLong());
    }
}
