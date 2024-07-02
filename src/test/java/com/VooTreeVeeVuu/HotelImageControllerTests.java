package com.VooTreeVeeVuu;

import com.VooTreeVeeVuu.controller.HotelImageController;
import com.VooTreeVeeVuu.domain.entity.HotelImage;
import com.VooTreeVeeVuu.domain.repository.HotelImageRepository;
import com.VooTreeVeeVuu.dto.HotelImageDTO;
import com.VooTreeVeeVuu.usecase.HotelImageUsecase.GetAllHotelImage.GetAllHotelImage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class HotelImageControllerTests {

    @Mock
    private MockMvc mockMvc;

    @InjectMocks
    private HotelImageController hotelImageController;
    @Mock
    private HotelImageRepository hotelImageRepository;

    @Mock
    private GetAllHotelImage getAllHotelImage;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(hotelImageController).build();
    }

    @Test
    @DisplayName("Test GET /hotel-images - Success")
    public void testGetAllImages() throws Exception {
        // Mock data
        HotelImageDTO image1 = new HotelImageDTO(1L, "image1.jpg", "base64string1", "image/jpeg", null);
        HotelImageDTO image2 = new HotelImageDTO(2L, "image2.jpg", "base64string2", "image/png", null);
        List<HotelImageDTO> images = Arrays.asList(image1, image2);

        // Mock service method
        when(getAllHotelImage.getAllHotelImage()).thenReturn(images);

        // Perform GET request
        mockMvc.perform(get("/api/hotel-images"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].imageName").value("image1.jpg"))
                .andExpect(jsonPath("$[0].imageBase64").value("base64string1"))
                .andExpect(jsonPath("$[0].imageType").value("image/jpeg"))
                .andExpect(jsonPath("$[0].imageUrl").value("/api/hotel-images/1"))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].imageName").value("image2.jpg"))
                .andExpect(jsonPath("$[1].imageBase64").value("base64string2"))
                .andExpect(jsonPath("$[1].imageType").value("image/png"))
                .andExpect(jsonPath("$[1].imageUrl").value("/api/hotel-images/2"));
    }


    @Test
    @DisplayName("Test GET /hotel-images/{imageId} - Success")
    public void testGetImage() throws Exception {
        // Mock data
        Long imageId = 1L;
        HotelImage image = new HotelImage(imageId, "image1.jpg", "base64string1".getBytes(), "image/jpeg", null);

        // Mock repository method
        when(hotelImageRepository.findById(imageId)).thenReturn(Optional.of(image));

        // Perform GET request
        mockMvc.perform(get("/api/hotel-images/{imageId}", imageId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.parseMediaType(image.getImageType())))
                .andExpect(header().string(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"image1.jpg\""))
                .andExpect(content().bytes(image.getImageBase64()));
    }

}
