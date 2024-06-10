package com.VooTreeVeeVuu.usecase.AccountUseCase;

import com.VooTreeVeeVuu.adapters.dto.AccountDTO;
import com.VooTreeVeeVuu.domain.entity.Account;
import com.VooTreeVeeVuu.domain.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetAccountUseCase {
	@Autowired
	private AccountRepository accountRepository;

	public Optional<AccountDTO> getAccountById (Long id) {
		return accountRepository.findById(id).map(this :: toDTO);
	}

	private AccountDTO toDTO (Account account) {
		AccountDTO dto = new AccountDTO();
		dto.setId(account.getId());
		dto.setUsername(account.getUsername());
		dto.setPassword(account.getPassword());
		dto.setEmail(account.getEmail());
		dto.setPhoneNum(account.getPhoneNum());
		dto.setEnabled(account.isEnabled());
		return dto;
	}
}