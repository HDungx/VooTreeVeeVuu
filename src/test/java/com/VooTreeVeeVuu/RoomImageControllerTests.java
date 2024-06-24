package com.VooTreeVeeVuu;

import com.VooTreeVeeVuu.controller.RoomImageController;
import com.VooTreeVeeVuu.domain.utils.Fac_Type;
import com.VooTreeVeeVuu.dto.FacilityDTO;
import com.VooTreeVeeVuu.dto.RoomDTO;
import com.VooTreeVeeVuu.dto.RoomImageDTO;
import com.VooTreeVeeVuu.dto.RoomTypeDTO;
import com.VooTreeVeeVuu.usecase.RoomImageUsecase.GetAllRoomImage.GetAllRoomImageImpl;
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class RoomImageControllerTests {
    @Mock
    private MockMvc mockMvc;

    @InjectMocks
    private RoomImageController roomImageController;

    @Mock
    private GetAllRoomImageImpl getAllRoomImageUseCase;


    private static final String END_POINT_PATH="/api/facilities";

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(roomImageController).build();
    }



}
