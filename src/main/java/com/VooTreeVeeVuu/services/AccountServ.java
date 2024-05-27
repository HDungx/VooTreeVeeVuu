package com.VooTreeVeeVuu.services;

import com.VooTreeVeeVuu.entity.Account;

import java.util.List;
import java.util.Optional;

public interface AccountServ {
	public List<Account> getAll ();

	public Optional<Account> getByUsername (String username);

	public Account save (Account account);

	public void delete (String username);
}
