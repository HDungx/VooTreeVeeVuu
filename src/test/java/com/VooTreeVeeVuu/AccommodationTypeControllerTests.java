package com.VooTreeVeeVuu;

import com.VooTreeVeeVuu.controller.AccommodationTypeController;
import com.VooTreeVeeVuu.dto.AccommodationTypeDTO;
import com.VooTreeVeeVuu.usecase.AccommodationTypeUsecase.CreateAccommodationType.CreateAccommodationTypeImpl;
import com.VooTreeVeeVuu.usecase.AccommodationTypeUsecase.DeleteAccommodationType.DeleteAccommodationTypeImpl;
import com.VooTreeVeeVuu.usecase.AccommodationTypeUsecase.GetAccommodationType.GetAccommodationTypeImpl;
import com.VooTreeVeeVuu.usecase.AccommodationTypeUsecase.GetAllAccommodationType.GetAllAccommodationTypeImpl;
import com.VooTreeVeeVuu.usecase.AccommodationTypeUsecase.UpdateAccommodationType.UpdateAccommodationTypeImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class AccommodationTypeControllerTests {

    @Mock
    private MockMvc mockMvc;

    @InjectMocks
    private AccommodationTypeController accommodationTypeController;

    @Mock
    private CreateAccommodationTypeImpl createAccommodationTypeUsecase;

    @Mock
    private UpdateAccommodationTypeImpl updateAccommodationTypeUsecase;

    @Mock
    private DeleteAccommodationTypeImpl deleteAccommodationTypeUsecase;

    @Mock
    private GetAllAccommodationTypeImpl getAllAccommodationTypeUsecase;

    @Mock
    private GetAccommodationTypeImpl getAccommodationTypeUsecase;



    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(accommodationTypeController).build();
    }

    @Test
    @DisplayName("Test GET /accommodation-types - Success")
    public void testGetAllAccommodationTypeDTOSuccess() throws Exception {
        // Mock data
        AccommodationTypeDTO type1 = new AccommodationTypeDTO(1L, "Hotel", null);
        AccommodationTypeDTO type2 = new AccommodationTypeDTO(2L, "Motel", null);
        AccommodationTypeDTO type3 = new AccommodationTypeDTO(3L, "Resort", null);
        AccommodationTypeDTO type4 = new AccommodationTypeDTO(4L, "Homestay", null);
        AccommodationTypeDTO type5 = new AccommodationTypeDTO(5L, "Apartment", null);
        List<AccommodationTypeDTO> accommodationTypeDTOList = Arrays.asList(type1, type2, type3, type4, type5);

        // Mock use case method
        when(getAllAccommodationTypeUsecase.getAllAccommodationTypeDTO()).thenReturn(accommodationTypeDTOList);

        // Perform GET request
        mockMvc.perform(get("/api/accommodationTypes"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].typeName").value("Hotel"))
                .andExpect(jsonPath("$[0].hotels").isEmpty())
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].typeName").value("Motel"))
                .andExpect(jsonPath("$[1].hotels").isEmpty())
                .andExpect(jsonPath("$[2].id").value(3))
                .andExpect(jsonPath("$[2].typeName").value("Resort"))
                .andExpect(jsonPath("$[2].hotels").isEmpty())
                .andExpect(jsonPath("$[3].id").value(4))
                .andExpect(jsonPath("$[3].typeName").value("Homestay"))
                .andExpect(jsonPath("$[3].hotels").isEmpty())
                .andExpect(jsonPath("$[4].id").value(5))
                .andExpect(jsonPath("$[4].typeName").value("Apartment"))
                .andExpect(jsonPath("$[4].hotels").isEmpty());
    }


    @Test
    @DisplayName("Test GET /accommodation-types/{id} - Success")
    public void testGetAccommodationTypeByIdSuccess() throws Exception {
        // Mock data
        Long typeId = 1L;
        AccommodationTypeDTO accommodationTypeDTO = new AccommodationTypeDTO(typeId, "Hotel", null);

        // Mock use case method
        when(getAccommodationTypeUsecase.getAccommodationTypeById(typeId)).thenReturn(Optional.of(accommodationTypeDTO));

        // Perform GET request
        mockMvc.perform(MockMvcRequestBuilders.get("/api/accommodationTypes/{id}", typeId))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(typeId))
                .andExpect(MockMvcResultMatchers.jsonPath("$.typeName").value("Hotel"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.hotels").isEmpty());
    }
    @Test
    @DisplayName("Test POST /accommodation-types - Success")
    public void testCreateAccommodationTypeSuccess() throws Exception {
        // Mock data
        AccommodationTypeDTO inputDTO = new AccommodationTypeDTO(null, "Villa", null);
        AccommodationTypeDTO outputDTO = new AccommodationTypeDTO(1L, "Villa", null);

        // Mock use case method
        when(createAccommodationTypeUsecase.createAccommodationType(any(AccommodationTypeDTO.class))).thenReturn(outputDTO);

        // Perform POST request
        mockMvc.perform(MockMvcRequestBuilders.post("/api/accommodationTypes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(inputDTO)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1L))
                .andExpect(MockMvcResultMatchers.jsonPath("$.typeName").value("Villa"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.hotels").isEmpty());
    }

    @Test
    @DisplayName("Test PUT /accommodation-types/update/{id} - Success")
    public void testUpdateAccommodationTypeSuccess() throws Exception {
        // Mock data
        Long typeId = 1L;
        AccommodationTypeDTO inputDTO = new AccommodationTypeDTO(typeId, "Villa", null);
        AccommodationTypeDTO outputDTO = new AccommodationTypeDTO(typeId, "Resort", null);

        // Mock use case method
        when(updateAccommodationTypeUsecase.updateAccommodationTypeDTO(typeId, inputDTO)).thenReturn(Optional.of(outputDTO));

        // Perform PUT request
        mockMvc.perform(MockMvcRequestBuilders.put("/api/accommodationTypes/update/{id}", typeId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(inputDTO)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(typeId))
                .andExpect(MockMvcResultMatchers.jsonPath("$.typeName").value("Resort"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.hotels").isEmpty());
    }

    @Test
    @DisplayName("Test DELETE /accommodation-types/delete/{id} - Success")
    public void testDeleteAccommodationTypeSuccess() throws Exception {
        // Mock data
        Long typeId = 1L;

        // Mock use case method
        doNothing().when(deleteAccommodationTypeUsecase).deleteAccommodationType(typeId);

        // Perform DELETE request
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/accommodationTypes/delete/{id}", typeId))
                .andExpect(MockMvcResultMatchers.status().isOk());

        // Verify that the use case method was called
        verify(deleteAccommodationTypeUsecase).deleteAccommodationType(typeId);
    }
}
