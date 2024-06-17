package com.VooTreeVeeVuu.controller;

import com.VooTreeVeeVuu.dto.LogsDTO;
import com.VooTreeVeeVuu.usecase.LogsUsecase.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/logs")
public class LogsController {
	 @Autowired
	 private CreateLogsUseCase createLogsUseCase;

    @Autowired
    private UpdateLogsUseCase updateLogsUseCase;

    @Autowired
	private DeleteLogsUseCase deleteLogsUseCase;

	@Autowired
	private GetAllLogsUseCase getAllLogsUseCase;

	@Autowired
	private GetLogsUseCase getLogsUseCase;

	@GetMapping ()
	public List<LogsDTO> getAllLogs(){
		return getAllLogsUseCase.getAllLogs();
	}

	@GetMapping ("/{id}")
	public Optional<LogsDTO> getLogsById (@PathVariable Long id){
		return getLogsUseCase.getLogsById(id);
	}

	@PostMapping
	public LogsDTO createLogs(@RequestBody LogsDTO dto) {
		return createLogsUseCase.createLogs(dto);
	}

	@PutMapping ("/update/{id}")
	public Optional<LogsDTO> updateLogs (@RequestBody LogsDTO dto, @PathVariable Long id) {
		return updateLogsUseCase.updateLogs(id,dto);
	}

	@DeleteMapping ("/delete/{id}")
	public void deleteLogs (@PathVariable Long id) {
		deleteLogsUseCase.deleteLogs(id);
	}

}
