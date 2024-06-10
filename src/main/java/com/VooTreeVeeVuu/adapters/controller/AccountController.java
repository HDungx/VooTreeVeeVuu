package com.VooTreeVeeVuu.adapters.controller;

import com.VooTreeVeeVuu.adapters.dto.AccountDTO;
import com.VooTreeVeeVuu.usecase.AccountUseCase.GetAccountUseCase;
import com.VooTreeVeeVuu.usecase.AccountUseCase.GetAllAccountsUseCase;
import com.VooTreeVeeVuu.usecase.AccountUseCase.UpdateStatusUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
