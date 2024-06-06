package com.VooTreeVeeVuu.adapters.repository;

import com.VooTreeVeeVuu.domain.entity.Account;
import com.VooTreeVeeVuu.domain.repository.AccountRepository;

import java.util.Optional;

public interface JpaAccountRepository extends AccountRepository {
	Optional<Account> findByUsername(String username);
}
