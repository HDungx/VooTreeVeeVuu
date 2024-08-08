package com.VooTreeVeeVuu;

import com.VooTreeVeeVuu.controller.RoomImageController;
import com.VooTreeVeeVuu.domain.entity.RoomImage;
import com.VooTreeVeeVuu.domain.repository.RoomImageRepository;
import com.VooTreeVeeVuu.domain.utils.Fac_Type;
import com.VooTreeVeeVuu.dto.FacilityDTO;
import com.VooTreeVeeVuu.dto.RoomDTO;
import com.VooTreeVeeVuu.dto.RoomImageDTO;
import com.VooTreeVeeVuu.dto.RoomTypeDTO;
import com.VooTreeVeeVuu.usecase.RoomImageUsecase.GetAllRoomImage.GetAllRoomImageImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class RoomImageControllerTests {
    @Mock
    private MockMvc mockMvc;

    @InjectMocks
    private RoomImageController roomImageController;

    @Mock
    private GetAllRoomImageImpl getAllRoomImageUseCase;
    @Mock
    private RoomImageRepository roomImageRepository;
    private static final String END_POINT_PATH="/api/facilities";

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(roomImageController).build();
    }

    @Test
    @DisplayName("Test GET /api/room-images - Success")
    public void testGetAllRoomImagesSuccess() throws Exception {
        // Mock data
        RoomImageDTO roomImage1 = new RoomImageDTO(1L, "image1.png", "base64string1", "image/png", null);
        RoomImageDTO roomImage2 = new RoomImageDTO(2L, "image2.jpg", "base64string2", "image/jpeg", null);

        List<RoomImageDTO> roomImages = Arrays.asList(roomImage1, roomImage2);

        // Mock use case method
        when(getAllRoomImageUseCase.getAllRoomImage()).thenReturn(roomImages);

        // Perform GET request
        mockMvc.perform(get("/api/room-images"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(roomImages.size()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(roomImage1.getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].imageName").value(roomImage1.getImageName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].imageType").value(roomImage1.getImageType()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].id").value(roomImage2.getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].imageName").value(roomImage2.getImageName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].imageType").value(roomImage2.getImageType()));
    }


    @Test
    @DisplayName("Test GET /api/room-images/{imageId} - Success")
    public void testGetImageSuccess() throws Exception {
        // Mock data
        RoomImage roomImage = new RoomImage();
        roomImage.setId(1L);
        roomImage.setImageName("image1.png");
        roomImage.setImageBase64("base64string".getBytes());
        roomImage.setImageType("image/png");

        // Mock repository method
        when(roomImageRepository.findById(1L)).thenReturn(Optional.of(roomImage));

        // Perform GET request
        mockMvc.perform(get("/api/room-images/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.parseMediaType(roomImage.getImageType())))
                .andExpect(header().string(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + roomImage.getImageName() + "\""))
                .andExpect(content().bytes(roomImage.getImageBase64()));
    }
}
