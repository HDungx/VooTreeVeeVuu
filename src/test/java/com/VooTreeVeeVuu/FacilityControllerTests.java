package com.VooTreeVeeVuu;
import com.VooTreeVeeVuu.controller.FacilityController;
import com.VooTreeVeeVuu.domain.utils.Fac_Type;
import com.VooTreeVeeVuu.dto.FacilityDTO;
import com.VooTreeVeeVuu.usecase.FacilityUsecase.CreateFacility.CreateFacilityImpl;
import com.VooTreeVeeVuu.usecase.FacilityUsecase.DeleteFacility.DeleteFacilityImpl;
import com.VooTreeVeeVuu.usecase.FacilityUsecase.GetAllFacility.GetAllFacilityImpl;
import com.VooTreeVeeVuu.usecase.FacilityUsecase.GetFacility.GetFacilityImpl;
import com.VooTreeVeeVuu.usecase.FacilityUsecase.UpdateFacility.UpdateFacilityImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
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
    private static final String END_POINT_PATH="/api/facilities";

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(facilityController).build();
    }


    @Test
    public void getAllFacilityTest() throws Exception {
        // Arrange
        FacilityDTO facility1 = new FacilityDTO(1L, Fac_Type.HOTEL, "WiFi", "icon1.png", null, null);
        FacilityDTO facility2 = new FacilityDTO(2L,  Fac_Type.ROOM, "Air Conditioning", "icon2.png", null, null);
        List<FacilityDTO> facilities = Arrays.asList(facility1, facility2);

        Mockito.when(getAllFacilityUseCase.getAllFacility()).thenReturn(facilities);

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
        Mockito.when(getFacilityUseCase.getFacilityById(1L)).thenReturn(Optional.of(facility));

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.get(END_POINT_PATH+"/1")
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
}
