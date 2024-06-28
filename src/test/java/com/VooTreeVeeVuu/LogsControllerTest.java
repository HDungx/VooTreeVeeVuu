package com.VooTreeVeeVuu;

import com.VooTreeVeeVuu.controller.LogsController;
import com.VooTreeVeeVuu.dto.LogsDTO;
import com.VooTreeVeeVuu.usecase.LogsUsecase.CreateLogs.CreateLogsImpl;
import com.VooTreeVeeVuu.usecase.LogsUsecase.DeleteLogs.DeleteLogsImpl;
import com.VooTreeVeeVuu.usecase.LogsUsecase.GetAllLogs.GetAllLogsImpl;
import com.VooTreeVeeVuu.usecase.LogsUsecase.GetLogs.GetLogsImpl;
import com.VooTreeVeeVuu.usecase.LogsUsecase.UpdateLogs.UpdateLogsImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class LogsControllerTest {
    @Mock
    private MockMvc mockMvc;

    @InjectMocks
    private LogsController logsController;

    private CreateLogsImpl createLogsUseCase;

    @Mock
    private UpdateLogsImpl updateLogsUseCase;

    @Mock
    private DeleteLogsImpl deleteLogsUseCase;

    @Mock
    private GetAllLogsImpl getAllLogsUseCase;

    @Mock
    private GetLogsImpl getLogsUseCase;
    private List<LogsDTO> logsList;




}
