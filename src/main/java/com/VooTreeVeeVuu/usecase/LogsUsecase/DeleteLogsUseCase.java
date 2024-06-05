package com.VooTreeVeeVuu.usecase.LogsUsecase;

import com.VooTreeVeeVuu.domain.repository.LogsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeleteLogsUseCase {
    @Autowired
    private LogsRepository logsRepository;

    @Transactional
    public void deleteLogs(Long id){logsRepository.deleteById(id);
    }
}
