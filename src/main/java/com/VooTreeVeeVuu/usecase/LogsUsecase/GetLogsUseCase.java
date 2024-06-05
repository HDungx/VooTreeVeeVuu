package com.VooTreeVeeVuu.usecase.LogsUsecase;

import com.VooTreeVeeVuu.adapters.dto.LogsDTO;
import com.VooTreeVeeVuu.domain.entity.Logs;
import com.VooTreeVeeVuu.domain.repository.LogsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetLogsUseCase {
    @Autowired
    private LogsRepository logsRepository;

    public Optional<LogsDTO> getLogsById(Long id){
        return logsRepository.findById(id).map(this :: toDTO);
    }

    private LogsDTO toDTO(Logs logs) {
        LogsDTO dto = new LogsDTO();
        dto.setAction(logs.getAction());
        dto.setDate(logs.getDate());
        dto.setHotel(logs.getHotel());
        dto.setStaff(logs.getStaff());
        return dto;
    }
}
