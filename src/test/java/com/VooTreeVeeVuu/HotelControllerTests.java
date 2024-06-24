package com.VooTreeVeeVuu;

import com.VooTreeVeeVuu.controller.HotelController;
import com.VooTreeVeeVuu.services.HotelService;
import com.VooTreeVeeVuu.usecase.HotelUsecase.DeleteHotel.DeleteHotelImpl;
import com.VooTreeVeeVuu.usecase.HotelUsecase.GetAllHotel.GetAllHotelImpl;
import com.VooTreeVeeVuu.usecase.HotelUsecase.GetHotel.GetHotelImpl;
import com.VooTreeVeeVuu.usecase.HotelUsecase.ImagesUpload.ImagesUploadImpl;
import com.VooTreeVeeVuu.usecase.HotelUsecase.UpdateStatusHotel.UpdateStatusHotelImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

public class HotelControllerTests {
    @Mock
    private MockMvc mockMvc;

    @InjectMocks
    private HotelController hotelController;

    @Mock
    private GetAllHotelImpl getAllHotelUseCase;

    @Mock
    private GetHotelImpl getHotelUseCase;

    @Mock
    private DeleteHotelImpl deleteHotelUseCase;

    @Mock
    private UpdateStatusHotelImpl updateStatusHotelUseCase;

    @Mock
    private ImagesUploadImpl imagesUploadUseCase;

    @Mock
    private HotelService hotelService;


    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(hotelController).build();
    }

    @Test
    public void testGetHotelById() throws Exception {

    }
}
