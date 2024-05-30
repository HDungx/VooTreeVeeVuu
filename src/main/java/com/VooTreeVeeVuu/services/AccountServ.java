package com.VooTreeVeeVuu.services;

import com.VooTreeVeeVuu.entity.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface AccountServ {
	public Page<Account> getAll (Pageable pageable);

	public List<Account> getAll();

	public Optional<Account> getByUsername (String username);

	public Account save (Account account);

	public void delete (String username);
}
