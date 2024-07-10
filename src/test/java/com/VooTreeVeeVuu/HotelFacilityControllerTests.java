package com.VooTreeVeeVuu;

import com.VooTreeVeeVuu.controller.FacilityController;
import com.VooTreeVeeVuu.controller.HotelFacilityController;
import com.VooTreeVeeVuu.domain.entity.Facility;
import com.VooTreeVeeVuu.domain.entity.Hotel;
import com.VooTreeVeeVuu.domain.utils.Fac_Type;
import com.VooTreeVeeVuu.dto.GetAllHotelFacDTO;
import com.VooTreeVeeVuu.usecase.HotelFacilityUsecase.DeleteHotelFacility.DeleteHotelFacilityImpl;
import com.VooTreeVeeVuu.usecase.HotelFacilityUsecase.GetAllHotelFacility.GetAllHotelFacilityImpl;
import com.VooTreeVeeVuu.usecase.HotelFacilityUsecase.GetHotelFacility.GetHotelFacilityImpl;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class HotelFacilityControllerTests {
    @Mock
    private MockMvc mockMvc;

    @InjectMocks
    private HotelFacilityController hotelFacilityController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(hotelFacilityController).build();
    }

    @Mock
    private DeleteHotelFacilityImpl deleteHotelFacilityUseCase;

    @Mock
    private GetAllHotelFacilityImpl getAllHotelFacilityUseCase;

    @Mock
    private GetHotelFacilityImpl getHotelFacilityUseCase;

    @Test
    @DisplayName("Test GET /api/hotelFacilities - Success")
    public void testGetAllHotelFacilitySuccess() throws Exception {
        // Mock data
        Hotel hotel1 = new Hotel(1L, "123 Street", "Hotel Name 1", "City 1", "123456789", 5, "Description 1", null, null, null, null);
        Facility facility1 = new Facility(1L, Fac_Type.HOTEL, "WiFi", "icon1.png");
        GetAllHotelFacDTO hotelFac1 = new GetAllHotelFacDTO(1L, facility1, hotel1);

        Hotel hotel2 = new Hotel(2L, "456 Avenue", "Hotel Name 2", "City 2", "987654321", 4, "Description 2", null, null, null, null);
        Facility facility2 = new Facility(2L, Fac_Type.ROOM, "Pool", "icon2.png");
        GetAllHotelFacDTO hotelFac2 = new GetAllHotelFacDTO(2L, facility2, hotel2);

        List<GetAllHotelFacDTO> hotelFacilities = Arrays.asList(hotelFac1, hotelFac2);

        // Mock use case method
        when(getAllHotelFacilityUseCase.getAllHotelFacility()).thenReturn(hotelFacilities);

        // Perform GET request
        mockMvc.perform(get("/api/hotelFacilities")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(hotelFacilities.size()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(hotelFac1.getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].facility.facId").value(hotelFac1.getFacility().getFacId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].facility.facName").value(hotelFac1.getFacility().getFacName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].facility.facIcon").value(hotelFac1.getFacility().getFacIcon()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].hotel.id").value(hotelFac1.getHotel().getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].hotel.address").value(hotelFac1.getHotel().getAddress()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].id").value(hotelFac2.getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].facility.facId").value(hotelFac2.getFacility().getFacId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].facility.facName").value(hotelFac2.getFacility().getFacName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].facility.facIcon").value(hotelFac2.getFacility().getFacIcon()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].hotel.id").value(hotelFac2.getHotel().getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].hotel.address").value(hotelFac2.getHotel().getAddress()));
    }


    @Test
    @DisplayName("Test GET /api/hotelFacilities/{id} - Success")
    public void testGetHotelFacilityByIdSuccess() throws Exception {
        // Mock data
        Long id = 1L;
        Hotel hotel = new Hotel(1L, "123 Street", "Hotel Name", "City", "123456789", 5, "Description", null, null, null, null);
        Facility facility = new Facility(1L, Fac_Type.HOTEL, "WiFi", "icon1.png");
        GetAllHotelFacDTO hotelFacility = new GetAllHotelFacDTO(1L, facility, hotel);

        // Mock use case method
        when(getHotelFacilityUseCase.getHotelFacilityById(id)).thenReturn(Optional.of(hotelFacility));

        // Perform GET request
        mockMvc.perform(get("/api/hotelFacilities/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(hotelFacility.getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.facility.facId").value(hotelFacility.getFacility().getFacId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.facility.facName").value(hotelFacility.getFacility().getFacName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.facility.facIcon").value(hotelFacility.getFacility().getFacIcon()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.hotel.id").value(hotelFacility.getHotel().getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.hotel.address").value(hotelFacility.getHotel().getAddress()));
    }

    @Test
    @DisplayName("Test DELETE /api/hotelFacilities/delete/{id} - Success")
    public void testDeleteHotelFacilitySuccess() throws Exception {
        // Mock data
        Long id = 1L;

        // Mock use case method
        doNothing().when(deleteHotelFacilityUseCase).deleteHotelFacility(id);

        // Perform DELETE request
        mockMvc.perform(delete("/api/hotelFacilities/delete/{id}", id))
                .andExpect(status().isOk());

        // Verify the interaction
        verify(deleteHotelFacilityUseCase).deleteHotelFacility(id);
    }


}
