package com.VooTreeVeeVuu.adapters.controller;

import com.VooTreeVeeVuu.adapters.dto.AccountDTO;
import com.VooTreeVeeVuu.adapters.dto.PassChangeDTO;
import com.VooTreeVeeVuu.services.AccountService;
import com.VooTreeVeeVuu.usecase.AccountUseCase.GetAccountUseCase;
import com.VooTreeVeeVuu.usecase.AccountUseCase.GetAllAccountsUseCase;
import com.VooTreeVeeVuu.usecase.AccountUseCase.UpdateStatusUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@CrossOrigin ("*")
@RestController
@RequestMapping ("/api/accounts")
public class AccountController {
	@Autowired
	private GetAllAccountsUseCase getAllAccountsUseCase;

	@Autowired
	private GetAccountUseCase getAccountUseCase;

	@Autowired
	private UpdateStatusUseCase updateStatusUseCase;

	@Autowired
	private AccountService accountService;

	@GetMapping ()
	public List<AccountDTO> getAllAccounts () {
		return getAllAccountsUseCase.getAllAccounts();
	}

	@GetMapping ("/{id}")
	public Optional<AccountDTO> getAccountById (@PathVariable Long id) {
		return getAccountUseCase.getAccountById(id);
	}

	@PutMapping ("/update/{id}")
	public Optional<AccountDTO> updateAccountStatus (@PathVariable Long id, @RequestBody AccountDTO accountDTO) {
		return updateStatusUseCase.updateStatus(id, accountDTO);
	}

	@PutMapping ("/{id}/change-pass")
	public ResponseEntity<String> changePassword (@PathVariable Long id, @RequestBody PassChangeDTO passChangeDTO) {
		accountService.changePassword(id, passChangeDTO);
		return ResponseEntity.ok("Password has been changed successfully");
	}

	@PostMapping ("/{id}/avatar")
	public ResponseEntity<String> uploadAvatar (@PathVariable Long id, @RequestParam ("avatar") MultipartFile file) {
		try
		{
			String filePath = accountService.updateAvatar(id, file);
			return ResponseEntity.ok(filePath);
		} catch (IOException e)
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload avatar");
		} catch (RuntimeException e)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
		}
	}
}
