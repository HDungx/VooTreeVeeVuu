package com.VooTreeVeeVuu.usecase.LogsUsecase;


import com.VooTreeVeeVuu.adapters.dto.LogsDTO;
import com.VooTreeVeeVuu.domain.entity.Logs;
import com.VooTreeVeeVuu.domain.repository.LogsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreateLogsUseCase {
    @Autowired
    private LogsRepository logsRepository;

    @Transactional
    public LogsDTO createLogs (LogsDTO logsDTO){
         Logs logs = toEntity(logsDTO);
         Logs saved = logsRepository.save(logs);
        return toDTO(saved);
    }

    private LogsDTO toDTO(Logs logs) {
       LogsDTO dto = new LogsDTO();
        dto.setAction(logs.getAction());
        dto.setDate(logs.getDate());
        dto.setHotel(logs.getHotel());
        dto.setStaff(logs.getStaff());
        return dto;
    }

    private Logs toEntity(LogsDTO logsDTO) {
        Logs logs = new Logs();
        logs.setAction(logsDTO.getAction());
        logs.setDate(logsDTO.getDate());
        logs.setHotel(logsDTO.getHotel());
        logs.setStaff(logsDTO.getStaff());
        return logs;
    }
}
