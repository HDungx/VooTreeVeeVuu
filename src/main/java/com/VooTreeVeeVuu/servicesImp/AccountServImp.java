package com.VooTreeVeeVuu.servicesImp;

import com.VooTreeVeeVuu.entity.Account;
import com.VooTreeVeeVuu.repository.AccountRepository;
import com.VooTreeVeeVuu.services.AccountServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServImp implements AccountServ {
	@Autowired
	AccountRepository accountRepository;

	@Override
	public List<Account> getAll () {
		return accountRepository.findAll();
	}

	@Override
	public Optional<Account> getByUsername (String username) {
		return accountRepository.findById(username);
	}

	@Override
	public Account save (Account account) {
		return accountRepository.save(account);
	}

	@Override
	public void delete (String username) {
		accountRepository.deleteById(username);
	}
}
