package com.VooTreeVeeVuu.usecase.LogsUsecase;

import com.VooTreeVeeVuu.adapters.dto.LogsDTO;
import com.VooTreeVeeVuu.domain.entity.Logs;
import com.VooTreeVeeVuu.domain.repository.LogsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetAllLogsUseCase {
    @Autowired
    private LogsRepository logsRepository;

    public List<LogsDTO> getAllLogs(){
        return logsRepository.findAll().stream().map(this :: toDTO).collect(Collectors.toList());
    }

    private LogsDTO toDTO(Logs logs) {
        LogsDTO dto = new LogsDTO();
        dto.setAction(logs.getAction());
        dto.setDate(logs.getDate());
        dto.setHotel(logs.getHotel());
        dto.setUser(logs.getUser());
        return dto;
    }
}
